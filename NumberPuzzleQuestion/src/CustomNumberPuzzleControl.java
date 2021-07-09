import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		for(int i=0;i<buttons.length;i++) {
			if(buttons[i]==buttonClicked) {
				if(emptyCellId==i-1 || emptyCellId==i+1 || emptyCellId==i-4 || emptyCellId==i+4) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId=i;
				}
				break;
			}
		}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		for(int i=0;i<arr.length;i++) {
			int a= getRandomNumber()%arr.length;
			int temp=arr[a];
			arr[a]=arr[i];
			arr[i]=temp;
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		int[] buttonIds = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<buttonIds.length;i++) {
			if(buttonIds[i]!=i+1) {
				winner = false;
				break;
			}
		}
		
		return winner;
	}
}