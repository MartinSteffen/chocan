package protocol;

import java.awt.*;
import java.awt.event.*;

/** A listener that you attach to the top-level Frame or JFrame of
 *  your application, so quitting the frame exits the application.
 */

public class ExitListener extends WindowAdapter {
  public void windowClosing(WindowEvent event) {
    System.exit(0);
  }
}
