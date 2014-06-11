package decorators;


public class Text {
	
	public String write(String text) {
		return text;
	}
}

abstract class TextDecorator extends Text {
	public abstract String write(String t);
}


