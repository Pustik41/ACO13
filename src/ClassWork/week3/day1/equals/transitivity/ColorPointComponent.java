package week3.day1.equals.transitivity;

import java.awt.*;

public class ColorPointComponent {
        private final Point point;
        private final Color color;
        public ColorPointComponent(int x, int y, Color color) {
            if (color == null)
                throw new NullPointerException();
            point = new Point(x, y);
            this.color = color;
        }
        /**
         * Returns the point-view of this color point.
         */
        public Point asPoint() {
            return point;
        }


        @Override public boolean equals(Object o) {
            if (!(o instanceof ColorPointComponent))
                return false;
            ColorPointComponent cp = (ColorPointComponent) o;
            return cp.point.equals(point) && cp.color.equals(color);
        }
}





