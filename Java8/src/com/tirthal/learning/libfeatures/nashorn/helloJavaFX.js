var msg = new javafx.scene.control.Label("I am Tirthal Patel");
msg.font = new javafx.scene.text.Font(80);

// The JavaFX Stage class is the top level JavaFX container. The primary Stage is constructed by the platform.
// Nashorn makes the stage object available through $STAGE (in upper case)
$STAGE.scene = new javafx.scene.Scene(msg);
$STAGE.title = "Hello World!";