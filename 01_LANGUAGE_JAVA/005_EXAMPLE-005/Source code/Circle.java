package com.example.aufgabe1;

import javafx.scene.canvas.GraphicsContext;

public class Circle {
	public static void CreateCircle(GraphicsContext gc, int v, int v1, int v2, int v3) {
		gc.strokeOval(v, v1, v2, v3);
	}
}
