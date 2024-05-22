javac:
	javac -d bin $$(find ./src | grep .java)

run:
	java -cp deps/mysql-connector-j-8.4.0.jar:bin detergents.App

clean:
	rm -fr ./bin/*