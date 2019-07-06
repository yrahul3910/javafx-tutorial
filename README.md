# JavaFX Tutorial

Follows along thenewboston tutorial for JavaFX

## Setting up IntelliJ IDEA

To set up IDEA for JavaFX development, download [JavaFX](https://gluonhq.com/products/javafx/) and extract the files. To make things easier, in IDEA,
go to File --> Other Settings --> Structure for New Projects --> Global Libraries, click the + icon, and select all the .jar files
under the `lib` folder of JavaFX. In a new project, go to File --> Project Structure --> Global Libraries, and right-click the
javafx-swt and click on Add to Modules. Next, go to Run --> Edit Configurations..., and in VM options, add

```
--module-path <full path to JavaFX lib folder> --add-modules javafx.controls,javafx.fxml,javafx.base
```
