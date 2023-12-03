package com.carloscsanz.day2

sealed class Cube(val times: Int)
class RedCube(times: Int): Cube(times)
class GreenCube(times: Int): Cube(times)
class BlueCube(times: Int): Cube(times)
