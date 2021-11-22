SET PATH=C:\software-portable\java\jdk1891\bin;C:\software-portable\java\jre1891\bin;%PATH%;
javac -d ./classe gestioneCellulare.java
javac -d ./classe Aggiungi.java
javac -d ./classe Cellulare.java
java -cp ./classe; gestioneCellulare
javadoc gestioneCellulare