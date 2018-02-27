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


Changelog in V1.23

- Implemented ATS support into the FMC 
- Implemented NavAids into the FMC
- Implemented DCT Waypoints into the FMC
- Added RTE pages
- Created new custom serialied Navdata files

TODO For Version 1.24:

- Implement all waypoints into the GUI.
- Implement algorithms to draw routes using data entered.
- Implement approaches and Star Transitions.
- Start looking at ways to implement FMC into X-Plane 11.

Changelog in V1.24.11

Bug Fixed: Now all DCT Waypoints with duplicate identifiers have been added. 
