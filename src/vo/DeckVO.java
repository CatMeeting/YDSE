package vo;

public class DeckVO {
	private int deckID;
	private String deckName;

	public DeckVO(int deckID, String deckName) {
		this.deckID = deckID;
		this.deckName = deckName;
	}

	public int getDeckID() {
		return deckID;
	}
	public String getDeckName() {
		return deckName;
	}


}
