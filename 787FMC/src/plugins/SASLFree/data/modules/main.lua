size = {2048,2048}

panel2d=false
panelWidth3d=2048
panelHeight3d=2048



addSearchPath("/modules")
--image1 = loadImage ( "FMS.png" )
components={

    
	 FMS{position={963,744,322,620},
	 cursor={
	 x=0,
	 y=0,
	 width=13,
	 height=13,
	 shape= sasl.gl.loadImage("cursor1.png"),	
	 hideOSCursor=true,
	 },
	 


	 
	 }

}

function draw()
drawAll(components);


end