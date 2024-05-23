package libarary;

import libarary.model.BookBuyModel;

public class BuyBook {
    private BookBuyModel bookBuyModel = new BookBuyModel();

    public void buyNewBook(int userId,int bookId,boolean isPayed){
        bookBuyModel.buyABook(userId, bookId, isPayed);
    }
}
