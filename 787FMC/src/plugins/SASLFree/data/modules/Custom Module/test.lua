size={400,640}

defineProperty("alt_hold", globalPropertyf("sim/cockpit2/autopilot/altitude_dial_ft"))          --We get the altitude to hold
defineProperty("altitude", globalPropertyf("sim/cockpit2/gauges/indicators/altitude_ft_pilot")) --We get the altiltude we are now
defineProperty("brightness", globalPropertyf("sim/cockpit2/electrical/instrument_brightness_ratio[0]")) --We get the brightness level so our text will be dimmed with the brightness switch [0] 

local font1=sasl.gl.loadFont("/font.ttf")
clRed={1.0 , 0.0 , 0.0 , 1.0 }

function draw()
--drawAll(components)
 
drawText( font1 , 0 ,0  , "Something test" , 20 ,false , false , TEXT_ALIGN_CENTER , clRed )

end 



