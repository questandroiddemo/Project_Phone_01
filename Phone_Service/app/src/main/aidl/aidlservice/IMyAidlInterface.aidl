// IMyAidlInterface.aidl
package aidlservice;
import aidlservice.RecentModel;
//import com.example.phone_service.ContactModel;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
String getText();
//List<RecentModel> getAllRecents();
}