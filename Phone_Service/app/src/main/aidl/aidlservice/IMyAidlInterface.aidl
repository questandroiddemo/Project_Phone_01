// IMyAidlInterface.aidl
package aidlservice;
import aidlservice.RecentModel;
import aidlservice.ContactModel;
import aidlservice.FavoriteModel;


interface IMyAidlInterface {


String getText();
void placeCall(String number);
List<String> getList();

//parcelables
List<RecentModel> getAllRecents();
List<ContactModel> getAllContacts();
List<FavoriteModel> getAllFavorites();

void deleteFavorite(int id);
void addToFavorite(in ContactModel contact);
void addToRecent(in ContactModel contact);


}