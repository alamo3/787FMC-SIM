size = {322,600}

name = "FMS";

print(name)
print(_VERSION)




image1 = sasl.gl.loadImage ( "FMS.png" );


 -- local socket = require("socket")
 
 -- udp = socket.udp()
-- udp:setpeername("127.0.0.1", 9876)
 
 
print("I'm here 1")



fmcFont= sasl.gl.loadFont("font.ttf");
fmcFont1= sasl.gl.loadFont("future.ttf");
clWhite={255.0,255.0,255.0};
clRed = {1.0 , 0.0 , 0.0 , 1.0}
test="787"..string.char(45).."9"
--print(test)
panelstate= createGlobalPropertys("panelstate","ident")


jLabel48= createGlobalPropertys("jLabel48","IDENT                  ")
pagenumber= createGlobalPropertys("pagenumber","1/1  ")
jLabel51=createGlobalPropertys("jLabel51","MODEL                   ")
jLabel52=createGlobalPropertys("jLabel52","787-9                   ")
jLabel49=createGlobalPropertys("jLabel49","NAVDATA                 ")
jLabel50=createGlobalPropertys("jLabel50","NAVIGRAPH 1801              ")
jLabel54=createGlobalPropertys("jLabel54","                            ")
jLabel53=createGlobalPropertys("jLabel53","                            ")
jLabel55=createGlobalPropertys("jLabel55","OP PROGRAM                  ")
jLabel56=createGlobalPropertys("jLabel56","OP042017                    ")
jLabel58=createGlobalPropertys("jLabel58","                            ")
jLabel59=createGlobalPropertys("jLabel59","                            ")
jLabel60=createGlobalPropertys("jLabel60","< INDEX                     ")
jLabel61=createGlobalPropertys("jLabel61","                  ENG RATING")
jLabel62=createGlobalPropertys("jLabel62","                  GENX 1B-64")
jLabel63=createGlobalPropertys("jLabel63","                      ACTIVE")
jLabel64=createGlobalPropertys("jLabel64","               JAN01FEB01/18")
jLabel65=createGlobalPropertys("jLabel65","                            ")
jLabel66=createGlobalPropertys("jLabel66","                            ")
jLabel67=createGlobalPropertys("jLabel67","                            ")
jLabel68=createGlobalPropertys("jLabel68","                            ")
jLabel69=createGlobalPropertys("jLabel69","                     DRAG/FF")
jLabel70=createGlobalPropertys("jLabel70","                    +0.0/0.0")
jLabel57=createGlobalPropertys("jLabel57","                  POS INIT >")
fmcComm=createGlobalPropertys("fmcCommand","nothing ")
scratch1=createGlobalPropertys("scratch","INITIALIZED")

typeA=sasl.createCommand("FMC/typeA","use to type A in FMC Scratchpad")
typeB=sasl.createCommand("FMC/typeB","use to type B in FMC Scratchpad")
typeC=sasl.createCommand("FMC/typeC","use to type C in FMC ScratchPad")
typeD=sasl.createCommand("FMC/typeD","use to type D in FMC Scratchpad")
typeE=sasl.createCommand("FMC/typeE","use to type E in FMC Scratchpad")
typeF=sasl.createCommand("FMC/typeF","use to type F in FMC Scratchpad")
typeG=sasl.createCommand("FMC/typeG","use to type G in FMC Scratchpad")
typeH=sasl.createCommand("FMC/typeH","use to type H in FMC Scratchpad")
typeI=sasl.createCommand("FMC/typeI","use to type I in FMC Scratchpad")
typeJ=sasl.createCommand("FMC/typeJ","use to type J in FMC Scratchpad")
typeK=sasl.createCommand("FMC/typeK","use to type K in FMC Scratchpad")
typeL=sasl.createCommand("FMC/typeL","use to type L in FMC Scratchpad")
typeM=sasl.createCommand("FMC/typeM","use to type M in FMC Scratchpad")
typeN=sasl.createCommand("FMC/typeN","use to type N in FMC Scratchpad")
typeO=sasl.createCommand("FMC/typeO","use to type O in FMC Scratchpad")
typeP=sasl.createCommand("FMC/typeP","use to type P in FMC Scratchpad")
typeQ=sasl.createCommand("FMC/typeQ","use to type Q in FMC Scratchpad")
typeR=sasl.createCommand("FMC/typeR","use to type R in FMC Scratchpad")
typeS=sasl.createCommand("FMC/typeS","use to type S in FMC Scratchpad")
typeT=sasl.createCommand("FMC/typeT","use to type T in FMC Scratchpad")
typeU=sasl.createCommand("FMC/typeU","use to type U in FMC Scratchpad")
typeV=sasl.createCommand("FMC/typeV","use to type V in FMC Scratchpad")
typeW=sasl.createCommand("FMC/typeW","use to type W in FMC Scratchpad")
typeX=sasl.createCommand("FMC/typeX","use to type X in FMC Scratchpad")
typeY=sasl.createCommand("FMC/typeY","use to type Y in FMC Scratchpad")
typeZ=sasl.createCommand("FMC/typeZ","use to type D in FMC Scratchpad")
clearScratch=createCommand("FMC/clearText","Use to delete one character in FMC ScratchPad")
deleteFMC=createCommand("FMC/deleteText","Use to set text to delete.")
type1=sasl.createCommand("FMC/type1","use to type 1 in FMC Scratchpad")
type2=sasl.createCommand("FMC/type2","use to type 2 in FMC Scratchpad")
type3=sasl.createCommand("FMC/type3","use to type 3 in FMC Scratchpad")
type4=sasl.createCommand("FMC/type4","use to type 4 in FMC Scratchpad")
type5=sasl.createCommand("FMC/type5","use to type 5 in FMC Scratchpad")
type6=sasl.createCommand("FMC/type6","use to type 6 in FMC Scratchpad")
type7=sasl.createCommand("FMC/type7","use to type 7 in FMC Scratchpad")
type8=sasl.createCommand("FMC/type8","use to type 8 in FMC Scratchpad")
type9=sasl.createCommand("FMC/type9","use to type 9 in FMC Scratchpad")
type0=sasl.createCommand("FMC/type0","use to type 0 in FMC Scratchpad")
typePeriod=sasl.createCommand("FMC/typePeriod","use to type . in FMC Scratchpad")
typeSlash=sasl.createCommand("FMC/typeSlash","use to type / in FMC Scratchpad")
typeSign=sasl.createCommand("FMC/typePlusMinus","use to type + or - in FMC Scratchpad")

fms1L=sasl.createCommand("FMC/button1L","LSK1L")
fms2L=sasl.createCommand("FMC/button2L","LSK2L")
fms3L=sasl.createCommand("FMC/button3L","LSK3L")
fms4L=sasl.createCommand("FMC/button4L","LSK4L")
fms5L=sasl.createCommand("FMC/button5L","LSK5L")
fms6L=sasl.createCommand("FMC/button6L","LSK6L")
fms1R=sasl.createCommand("FMC/button1R","LSK1R")
fms2R=sasl.createCommand("FMC/button2R","LSK2R")
fms3R=sasl.createCommand("FMC/button3R","LSK3R")
fms4R=sasl.createCommand("FMC/button4R","LSK4R")
fms5R=sasl.createCommand("FMC/button5R","LSK5R")
fms6R=sasl.createCommand("FMC/button6R","LSK6R")


scratchStore=get(scratch1)


function button1L(phase)

if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button1L ")
end
return 1
end

function button2L(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button2L ")
end 
return 1
end

function button3L(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button3L ")
end
return 1
end

function button4L(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button4L ")
end
return 1
end

function button5L(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button5L ")
end 
return 1
end

function button6L(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button6L ")
end
return 1
end 

function button1R(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button1R ")

end 
return 1
end

function button2R(phase)

if phase == SASL_COMMAND_BEGIN then 
set(fmcComm,"button2R ")
end
return 1
end

function button3R(phase)

if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button3R ")
end
return 1
end

function button4R(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button4R ")
end
return 1
end

function button5R(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button5R ")
end
return 1
end

function button6R(phase)
if phase == SASL_COMMAND_BEGIN then
set(fmcComm,"button6R ")
end
return 1
end

sasl.registerCommandHandler(fms1L,0,button1L)
sasl.registerCommandHandler(fms2L,0,button2L)
sasl.registerCommandHandler(fms3L,0,button3L)
sasl.registerCommandHandler(fms4L,0,button4L)
sasl.registerCommandHandler(fms5L,0,button5L)
sasl.registerCommandHandler(fms6L,0,button6L)
sasl.registerCommandHandler(fms1R,0,button1R)
sasl.registerCommandHandler(fms2R,0,button2R)
sasl.registerCommandHandler(fms3R,0,button3R)
sasl.registerCommandHandler(fms4R,0,button4R)
sasl.registerCommandHandler(fms5R,0,button5R)
sasl.registerCommandHandler(fms6R,0,button6R)

function scratchA(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."A")
end
return 0
end



function scratchB(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."B")
end
return 1
end

function scratchC(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."C")
end
return 1
end

function scratchD(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."D")
end
return 1
end

function scratchE(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."E")
end
return 1
end

function scratchF(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."F")
end
return 1
end

function scratchG(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."G")
end
return 1
end

function scratchH(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."H")
end
return 1
end

function scratchI(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."I")
end
return 1
end

function scratchJ(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."J")
end
return 1
end

function scratchK(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."K")
end
return 1
end

function scratchL(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."L")
end
return 1
end

function scratchM(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."M")
end
return 1
end

function scratchN(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."N")
end
return 1
end

function scratchO(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."O")
end
return 1
end

function scratchP(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."P")
end
return 1
end

function scratchQ(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."Q")
end
return 1
end

function scratchR(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."R")
end
return 1
end

function scratchS(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."S")
end
return 1
end

function scratchT(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."T")
end
return 1
end

function scratchU(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."U")
end
return 1
end

function scratchV(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."V")
end
return 1
end

function scratchW(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."W")
end
return 1
end

function scratchX(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."X")
end
return 1
end

function scratchY(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."Y")
end
return 1
end

function scratchZ(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."Z")
end
return 1
end

function scratchSpace(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.." ")
end
return 1
end

function scratchSlash(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."/")
end
return 1
end

function scratchClear(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore:sub(1,-2))
end
return 1
end

function scratchPeriod(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore..".")
end
return 1
end

function scratchDelete(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)

if scratchStore == "DELETE" then
set(scratch1,"") 
else
set(scratch1,"DELETE")
end
end
return 1
end

function scratchNumOne(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."1")
end
return 1
end

function scratch2(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."2")
end
return 1
end

function scratch3(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."3")
end
return 1
end

function scratch4(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."4")
end
return 1
end

function scratch5(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."5")
end
return 1
end

function scratch6(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."6")
end
return 1
end

function scratch7(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."7")
end
return 1
end

function scratch8(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."8")
end
return 1
end

function scratch9(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."9")
end
return 1
end

function scratch0(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
set(scratch1,scratchStore.."0")
end
return 1
end

function scratchSign(phase)
if phase == SASL_COMMAND_BEGIN then
scratchStore=get(scratch1)
if string.sub(scratchStore, -1) == "-" then
set(scratch1,scratchStore:sub(1,-2).."+") 
elseif string.sub(scratchStore, -1) == "+" then
set(scratch1,scratchStore:sub(1,-2).."-")
else
set(scratch1,scratchStore.."-")
end
end
return 1
end

sasl.registerCommandHandler(typeA , 1, scratchA)
sasl.registerCommandHandler(typeB , 1, scratchB)
sasl.registerCommandHandler(typeC , 1, scratchC)
sasl.registerCommandHandler(typeD , 1, scratchD)
sasl.registerCommandHandler(typeE , 1, scratchE)
sasl.registerCommandHandler(typeF , 1, scratchF)
sasl.registerCommandHandler(typeG , 1, scratchG)
sasl.registerCommandHandler(typeH , 1, scratchH)
sasl.registerCommandHandler(typeI , 1, scratchI)
sasl.registerCommandHandler(typeJ , 1, scratchJ)
sasl.registerCommandHandler(typeK , 1, scratchK)
sasl.registerCommandHandler(typeL , 1, scratchL)
sasl.registerCommandHandler(typeM , 1, scratchM)
sasl.registerCommandHandler(typeN , 1, scratchN)
sasl.registerCommandHandler(typeO , 1, scratchO)
sasl.registerCommandHandler(typeP , 1, scratchP)
sasl.registerCommandHandler(typeQ , 1, scratchQ)
sasl.registerCommandHandler(typeR , 1, scratchR)
sasl.registerCommandHandler(typeS , 1, scratchS)
sasl.registerCommandHandler(typeT , 1, scratchT)
sasl.registerCommandHandler(typeU , 1, scratchU)
sasl.registerCommandHandler(typeV , 1, scratchV)
sasl.registerCommandHandler(typeW , 1, scratchW)
sasl.registerCommandHandler(typeX , 1, scratchX)
sasl.registerCommandHandler(typeY , 1, scratchY)
sasl.registerCommandHandler(typeZ , 1, scratchZ)
sasl.registerCommandHandler(clearScratch , 1, scratchClear)
sasl.registerCommandHandler(deleteFMC , 1, scratchDelete)
 sasl.registerCommandHandler(type1 , 1, scratchNumOne)
 sasl.registerCommandHandler(type2 , 1, scratch2)
 sasl.registerCommandHandler(type3 , 1, scratch3)
sasl.registerCommandHandler(type4 , 1, scratch4)
	sasl.registerCommandHandler(type5 , 1, scratch5)
sasl.registerCommandHandler(type6 , 1, scratch6)
sasl.registerCommandHandler(type7 , 1, scratch7)
sasl.registerCommandHandler(type8 , 1, scratch8)
sasl.registerCommandHandler(type9 , 1, scratch9)
sasl.registerCommandHandler(type0 , 1, scratch0)
sasl.registerCommandHandler(typeSign , 1, scratchSign)
sasl.registerCommandHandler(typeSlash,1,scratchSlash)

function update()
propZuluTimeHour =  globalPropertyi("sim/cockpit2/clock_timer/zulu_time_hours")
propZuluTimeMinute=  globalPropertyi("sim/cockpit2/clock_timer/zulu_time_minutes")
propZuluTimeSecond=	globalPropertyi("sim/cockpit2/clock_timer/zulu_time_seconds")   

timeFormated=string.format("%s:%s:%s",tostring(get(propZuluTimeHour)),tostring(get(propZuluTimeMinute)),tostring(get(propZuluTimeSecond)))
--print(get(propZuluTimeHour))


end

function draw()

sasl.gl.drawTexture ( image1 , 0 , 0 , 322 , 450)
sasl.gl.drawText(fmcFont1,35,195,tostring(get(scratch1)):match("^%s*(.-)%s*$"),20,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,17,431,tostring(get(propZuluTimeHour)),14,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,35,431,tostring(get(propZuluTimeMinute)),14,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,62,431.4,tostring(get(propZuluTimeSecond)).." Z",14,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,160,405,tostring(get(jLabel48)):match("^%s*(.-)%s*$"),11.5,false,false,TEXT_ALIGN_CENTER,clWhite)
sasl.gl.drawText(fmcFont,277,409,"PAGE "..get(pagenumber):match("^%s*(.-)%s*$"),8,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont,72,395,get(jLabel51):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont1,72,380,get(jLabel52):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont,46,367	,get(jLabel49):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont1,44,350,get(jLabel50):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,85,337,get(jLabel54):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont1,45,320,get(jLabel53):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,45,307,get(jLabel55):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont1,44,291,get(jLabel56):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,44,276,get(jLabel58):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont1,44,259,get(jLabel59):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont1,42,228,get(jLabel60):match("^%s*(.-)%s*$"),15,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont,235,395,get(jLabel61):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_LEFT,clWhite)
sasl.gl.drawText(fmcFont1,280,380,get(jLabel62):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont,280,367,get(jLabel63):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont1,279,350,get(jLabel64):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont,280,337,get(jLabel65):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont1,280,320,get(jLabel66):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont,280,307,get(jLabel67):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont1,280,291,get(jLabel68):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont,280,276,get(jLabel69):match("^%s*(.-)%s*$"),6,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont1,280,259,get(jLabel70):match("^%s*(.-)%s*$"),16,false,false,TEXT_ALIGN_RIGHT,clWhite)
sasl.gl.drawText(fmcFont1,282,228,get(jLabel57):match("^%s*(.-)%s*$"),15,false,false,TEXT_ALIGN_RIGHT,clWhite)

end






