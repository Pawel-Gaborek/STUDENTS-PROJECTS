package com.example.aufgabe2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Geometry {
	public static void geometry(GraphicsContext gc, int x, int y, int width, int height, int r, int g, int b, int lineWeidth) {
		try {
			if ((r>0 && r<257) && (g>0 && g<257) && (b>0 && b<257))
			{
				gc.strokeRect(x, y, width, height);
				gc.setFill(Color.rgb(r, g, b));
				gc.fillRect(x, y, width, height);
				gc.setLineWidth(lineWeidth);
				gc.setLineWidth(10.0);
				for (int i = 0; i < lineWeidth; i++) {
					width=width+2;
					height=height+2;
					gc.strokeRect(x--, y--, width, height);
					System.out.print(width+"\n");
				}
			}
		}
		catch (Exception e)
		{
			System.out.print("error "+e);
		}
	}
}
