javac:
	javac -d bin $$(find ./src | grep .java)

clean:
	rm -fr ./bin/*