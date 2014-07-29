package com.rumblesan.giftest

import processing.core.PApplet
import processing.core.PConstants._

import scala.math._


class Giftest extends PApplet {

  var gifFrame = 0

  lazy val maxFrame:  Double = 360.0

  lazy val xSize:     Int        = 200
  lazy val ySize:     Int        = 200
  lazy val centre:    (Int, Int) = (xSize / 2, ySize / 2)

  lazy val sections:  Int        = 8
  lazy val sectAngle: Double     = (2 * Pi) / sections // radians baby
  lazy val segments:  Int        = 2
  lazy val spokeSize: Double     = 100
  lazy val segDif:    Double     = spokeSize / segments

  def calcPointFromCentre(centre: (Int, Int), angle: Double, distance: Double): (Double, Double) = {
    (distance * sin(angle) + centre._1, distance * cos(angle) + centre._2)
  }

  override def setup {
    size(xSize, ySize)
    smooth()
    frameRate(30)

    background(200, 255, 255)
  }

  override def draw {
    background(200, 255, 255)

    stroke(0)

    for {
      l <- 0 until sections
      lineEnd = calcPointFromCentre(centre, sectAngle * l, spokeSize)
      _ = line(centre._1, centre._2, lineEnd._1.toFloat, lineEnd._2.toFloat)

      seg <- 1 to segments
      segDistance = (seg / segments) * spokeSize
      end1 = calcPointFromCentre(centre, sectAngle * l, segDistance)
      end2 = calcPointFromCentre(centre, sectAngle * (l + 1), segDistance)
      _ = line(end1._1.toFloat, end1._2.toFloat, end2._1.toFloat, end2._2.toFloat)
    } yield ()

  }

}
