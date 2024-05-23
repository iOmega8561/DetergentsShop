# Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:

javac:
	javac -d bin/main $$(find ./src/main | grep .java)
	javac -d bin/test $$(find ./src/test | grep .java) -cp bin/main:deps/junit-platform-console-standalone-1.11.0-M2.jar

run:
	java -cp deps/mysql-connector-j-8.4.0.jar:bin/main detergents.Main

test:
	java -jar deps/junit-platform-console-standalone-1.11.0-M2.jar execute -c detergents.control.GestionePiattaforma_RegistrazioneTest -cp deps/mysql-connector-j-8.4.0.jar:bin/main:bin/test

clean:
	rm -fr ./bin/*