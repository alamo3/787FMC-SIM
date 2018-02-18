# 787FMC-SIM
I am trying to imitate a 787 FMC using java programming

Current Changes V1.19:


- Fixed Bug while Choosing runways by rewriting algorithm
- Added Legs page
- Added ability to choose transitions
- Added Position Reference Page

Changelog  V1.21:

- Added Departure airport Star Page (Still need to add functionality but the displaying supposedly works)
- Fixed bug that caused Departure Selection page to glitch when changing Origin from RTE Page


Changelog in V1.22;

- Added logic to pull airways and cache them for further use (It takes a long time to do this so i saved it once and for all and will regenerate it every month)
- Added caching functionality to application

Bug Fixed: The latitude and longitude of the airways were being miscalculated and it has been fixed

TODO For Version 1.23:

- Add ATS Support to the actual FMC.
- Start working on implenting NavAids and the ability to choose multiple WPTS if there are duplicates
- Start working on binary search method to efficiently search through airways 
