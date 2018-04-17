--test for lua Socket

print("Lua UDP Started")


local socket = require("socket")

udp = socket.udp()
udp:setpeername("127.0.0.1", 9876)
udp:settimeout(100)
udp:send("I see you ")
data = udp:receive()
if data then
    print("Received: ", data)
end

