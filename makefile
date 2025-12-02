# Copyright (c) 2025 Giuseppe Rocco
# Copyright (c) 2025 Federica Mosca 
# Copyright (c) 2025 Vittorio Monfrecola
# Licensed under the MIT License. See the LICENSE file for details.

build:
	javac -d bin/main $$(find ./src/main | grep .java) \
		  -cp bin/main:deps/json-simple-1.1.1.jar && \
	javac -d bin/test $$(find ./src/test | grep .java) \
	      -cp bin/main:deps/junit-platform-console-standalone-1.11.0-M2.jar

run:
	java -cp deps/json-simple-1.1.1.jar:deps/mariadb-java-client-3.4.0.jar:bin/main com.romomo.Main

test:
	java -jar deps/junit-platform-console-standalone-1.11.0-M2.jar execute \
	     -c com.romomo.control.GestionePiattaforma_RegistrazioneTest \
		 -c com.romomo.control.GestionePiattaforma_AggiuntaProdottoTest \
		 -c com.romomo.control.GestionePiattaforma_RichiestaReportTest \
		 -cp deps/mariadb-java-client-3.4.0.jar:bin/main:bin/test

clean:
	rm -fr ./bin