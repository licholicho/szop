package decorators;

public class ZlotyDekorator extends TextDecorator {

	Text text;

	public ZlotyDekorator() {
	}
	
	public void setText(Text text) {
		this.text = text;
	}
	
	public String addZloty(String t) {
		t += "0 zl";
		return t;
	}

	@Override
	public String write(String t) {
		t = addZloty(t);
		return text.write(t);		
	}
}