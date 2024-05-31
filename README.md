
![Space Age](https://github.com/s-kettle/mars-rover/assets/156723890/1c0eaf7e-6b15-44a4-a223-090fcea03964)

## The Brief

A rover has been delivered to Mars on a square/rectangular plateau, which has been divided into an equal grid 
for simple navigation. This plateau will never exceed 5 by 5.
An app is required that will help the rover navigate it's new surroundings. 
The rover's position is represented by an x and y co-ordinate, as well as a directional heading (N, E, S, W). For example, 
a rover with position 0, 0, N is placed at the bottom left of the 
plateau and faces north.

### Sending information
Once the rover is placed, it is programmed to accept a string of instructions:

- M - move the rover 1 grid point in the direction it's facing.
- L - rotate the rover 90° anti-clockwise
- R - rotate the rover 90° clockwise

This information is received as a single string of format: MLR.

### Sample data
Once the rover has moved to a new location on the plateau, it will automatically sample the location. The rover may find titanium, aluminium, tin, copper or gold on the surface. This is randomly generated for each plateau instance.

### Example input

A plateau is created with the input `5 5`.\
A rover of position `0 0 N` given instructions `MMRM` will report location `1 2 E`.\
A rover of position `2 3 S` given instructions `MLMLMRM` will report location `4 3 E`.

## Installation

1. Install [Java](https://www.java.com/en/download/) (recommended version 21.0).
2. Install a [Java IDE](https://www.jetbrains.com/idea/download/) (IntelliJ Community Edition recommended)
3. Clone this repository and open with your IDE.
4. Navigate to `src/main/java/app/Main`.
5. Press 'run'

The application can be used from the IDE terminal.

## Future considerations

- [ ] Implement logic for multiple rovers
- [ ] Handle collision of rovers on single plateau
- [x] Allow rovers to take samples from Mars
- [ ] Add obstacles to the plateau
- [x] Create an interface for space vehicles
- [ ] Implement logic for different types of space vehicle
