#pragma comment(lib, "ws2_32.lib")
#include <iostream>

#include <winsock2.h>


#include <string.h>
#if defined(WIN32)
#include <Windows.h>
#endif
#include <stdio.h>
#include <conio.h>
#include <thread>
#include<stddef.h>


#if IBM
#include <windows.h>
#endif
#if LIN
#include <GL/gl.h>
#elif __GNUC__
#include <OpenGL/gl.h>
#else
#include <GL/gl.h>
#endif


#include <XPLMDataAccess.h>
#include <XPLMProcessing.h>
#include <XPLMUtilities.h>
#include <chrono>


#ifndef XPLM300
#error This is made to be compiled against the XPLM300 SDK
#endif

#define BUFLEN 512
#define PORT 52000


#define SCK_VERSION2 0x0202

static bool quit = false;


using namespace std;


XPLM_API XPLMDataRef command;
XPLM_API XPLMDataRef left1A;
XPLM_API XPLMDataRef left1B;
XPLM_API XPLMDataRef left2A;
XPLM_API XPLMDataRef left2B;
XPLM_API XPLMDataRef left3A;
XPLM_API XPLMDataRef left3B;
XPLM_API XPLMDataRef left4A;
XPLM_API XPLMDataRef left4B;
XPLM_API XPLMDataRef left5A;
XPLM_API XPLMDataRef left5B;
XPLM_API XPLMDataRef left6;
XPLM_API XPLMDataRef right1A;
XPLM_API XPLMDataRef right1B;
XPLM_API XPLMDataRef right2A;
XPLM_API XPLMDataRef right2B;
XPLM_API XPLMDataRef right3A;
XPLM_API XPLMDataRef right3B;
XPLM_API XPLMDataRef right4A;
XPLM_API XPLMDataRef right4B;
XPLM_API XPLMDataRef right5A;
XPLM_API XPLMDataRef right5B;
XPLM_API XPLMDataRef right6;
XPLM_API XPLMDataRef panelState;


string sendData = "";
 
struct struct1{
	int                       structSize;
	XPLMFlightLoopPhaseType   phase;
	XPLMFlightLoop_f          callbackFunc;
	void *                    refcon;
} XPLMCreateFlightLoop_s;

struct1 testS;



char buf[BUFLEN];


 

void startApp()

{

	command = XPLMFindDataRef("fmcCommand");
	panelState = XPLMFindDataRef("panelstate");
	left1A = XPLMFindDataRef("jLabel51");
	left1B = XPLMFindDataRef("jLabel52");
	 left2A = XPLMFindDataRef("jLabel49");
	 left2B = XPLMFindDataRef("jLabel50");
	  left3A = XPLMFindDataRef("jLabel54");
	  left3B = XPLMFindDataRef("jLabel53");
	  left4A = XPLMFindDataRef("jLabel55");
	  left4B = XPLMFindDataRef("jLabel56");
	  left5A = XPLMFindDataRef("jLabel58");
	  left5B = XPLMFindDataRef("jLabel59");
	  left6 = XPLMFindDataRef("jLabel60");
	  right1A = XPLMFindDataRef("jLabel61");
	  right1B = XPLMFindDataRef("jLabel62");
	  right2A = XPLMFindDataRef("jLabel63");
	  right2B = XPLMFindDataRef("jLabel64");
	  right3A = XPLMFindDataRef("jLabel65");
	  right3B= XPLMFindDataRef("jLabel66");
	  right4A = XPLMFindDataRef("jLabel67");
	  right4B = XPLMFindDataRef("jLabel68");
	  right5A = XPLMFindDataRef("jLabel69");
	  right5B = XPLMFindDataRef("jLabel70");
	  right6 = XPLMFindDataRef("jLabel57");

	if (!command) {
		XPLMDebugString("DATAREF FAILED\n");
	}
	else {
		SOCKET s;
		
		struct sockaddr_in server, si_other;
		XPLMDebugString("[787 UDP] STRUCTS SUCCESSFUL\n");
		int slen, recv_len;
		WSADATA wsa;
		slen = sizeof(si_other);


		if (WSAStartup(MAKEWORD(2, 2), &wsa) != 0)
		{
			XPLMDebugString("[787 UDP] Winsock Initialization Failed\n");
			exit(EXIT_FAILURE);
		}


		if ((s = socket(AF_INET, SOCK_DGRAM, 0)) == INVALID_SOCKET)
		{
			XPLMDebugString("[787 UDP] SOCKET CREATION FAILED\n");
		}
		XPLMDebugString("[787 UDP] SOCKET CREATED\n");
		
		server.sin_family = AF_INET;
		server.sin_addr.s_addr = inet_addr("127.0.0.1");
		server.sin_port = htons(PORT);

		if (::bind(s, (struct sockaddr *)&server, sizeof(server)) == SOCKET_ERROR)
		{
			XPLMDebugString("[787 UDP] Bind failed with error\n");
		}


		XPLMDebugString("[787 UDP] BIND SUCCESSFULL ON PORT 52000\n");
		
		XPLMDebugString("[787 UDP] Initializing Client\n");

		XPLMDebugString("[787 UDP] Connecting to JVM Server\n");
		while (quit == false)
		{

			//clear the buffer by filling null, it might have previously received data
			memset(buf, '\0', BUFLEN);

			XPLMDebugString("787 UDP : Waiting for command \n");
			//try to receive some data, this is a blocking call
			recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
			XPLMDebugString(buf);

				if (strcmp(buf,"returnCommand")==0) {
					XPLMDebugString("[787 UDP] Returning FMC STATE\n");
					XPLMGetDatab(command, &buf, 0, sizeof(buf));
					sendData = buf;
					sendto(s,sendData.c_str(), 256, 0, (struct sockaddr*) &si_other, slen);
					XPLMGetDatab(panelState, &buf, 0, 17);
					sendData = buf;
					sendto(s, sendData.c_str(), 256, 0, (struct sockaddr*) &si_other, slen);
				}
				else if(strcmp(buf,"setDisplay")==0) {
					XPLMDebugString("[787 UDP] Returning FMC STATE\n");
					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
                    XPLMSetDatab(left1A,&buf,0,17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left1B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left2A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left2B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left3A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left3B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left4A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left4B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left5A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left5B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(left6, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right1A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right1B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right2A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right2B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right3A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right3B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right4A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right4B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right5A, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right5B, &buf, 0, 17);

					recvfrom(s, buf, 512, 0, (struct sockaddr *) &si_other, &slen);
					XPLMSetDatab(right6, &buf, 0, 17);

				}

			

			
		}
		XPLMDebugString("[787 UDP] Exit Code 1\n");
		closesocket(s);
		WSACleanup();
	}


}





float startPlugin(float inElapsedLast, float inElapsedsinceLastloop, int inCounter, void *inRefCon) {

	std::thread t1(startApp);
	t1.detach();
	return 0;
}


PLUGIN_API int XPluginStart(char * outName, char * outSignature, char * outDescription) {

	strcpy(outName, "MAG 787");
	strcpy(outSignature, "mag787.udpexport");
	strcpy(outDescription, "EXPORTS 787 DATA OVER UDP TO JVM");

	testS.structSize = 10;
	testS.phase = xplm_FlightLoop_Phase_BeforeFlightModel;
	testS.callbackFunc = startPlugin;
	testS.refcon = NULL;
	XPLMDebugString("[787 UDP] ATTEMPTING TO START \n");
	XPLMRegisterFlightLoopCallback(&startPlugin, -20, NULL);

	

	return 1;
}

PLUGIN_API void XPluginStop(void) {
	
	quit = true;
	XPLMDebugString("[787 UDP] Server Shutting Down\n");

}

PLUGIN_API int XPluginEnable(void) {
	//::thread t1(startApp);
	quit = false;
	return 1;
}

PLUGIN_API void XPluginDisable(void) {
	quit = true;
	XPLMDebugString("[787 UDP] Server Shutting Down\n");
	
}

PLUGIN_API void XPluginReceiveMessage(XPLMPluginID inFrom, int inMessage, void * inParam) {


}






