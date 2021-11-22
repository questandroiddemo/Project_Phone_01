/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package aidlservice;
public interface IMyAidlInterface extends android.os.IInterface
{
  /** Default implementation for IMyAidlInterface. */
  public static class Default implements aidlservice.IMyAidlInterface
  {
    @Override public java.lang.String getText() throws android.os.RemoteException
    {
      return null;
    }
    @Override public void placeCall(java.lang.String number) throws android.os.RemoteException
    {
    }
    @Override public java.util.List<java.lang.String> getList() throws android.os.RemoteException
    {
      return null;
    }
    //parcelables

    @Override public java.util.List<aidlservice.RecentModel> getAllRecents() throws android.os.RemoteException
    {
      return null;
    }
    @Override public java.util.List<aidlservice.ContactModel> getAllContacts() throws android.os.RemoteException
    {
      return null;
    }
    @Override public java.util.List<aidlservice.FavoriteModel> getAllFavorites() throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements aidlservice.IMyAidlInterface
  {
    private static final java.lang.String DESCRIPTOR = "aidlservice.IMyAidlInterface";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an aidlservice.IMyAidlInterface interface,
     * generating a proxy if needed.
     */
    public static aidlservice.IMyAidlInterface asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof aidlservice.IMyAidlInterface))) {
        return ((aidlservice.IMyAidlInterface)iin);
      }
      return new aidlservice.IMyAidlInterface.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getText:
        {
          data.enforceInterface(descriptor);
          java.lang.String _result = this.getText();
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_placeCall:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.placeCall(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_getList:
        {
          data.enforceInterface(descriptor);
          java.util.List<java.lang.String> _result = this.getList();
          reply.writeNoException();
          reply.writeStringList(_result);
          return true;
        }
        case TRANSACTION_getAllRecents:
        {
          data.enforceInterface(descriptor);
          java.util.List<aidlservice.RecentModel> _result = this.getAllRecents();
          reply.writeNoException();
          reply.writeTypedList(_result);
          return true;
        }
        case TRANSACTION_getAllContacts:
        {
          data.enforceInterface(descriptor);
          java.util.List<aidlservice.ContactModel> _result = this.getAllContacts();
          reply.writeNoException();
          reply.writeTypedList(_result);
          return true;
        }
        case TRANSACTION_getAllFavorites:
        {
          data.enforceInterface(descriptor);
          java.util.List<aidlservice.FavoriteModel> _result = this.getAllFavorites();
          reply.writeNoException();
          reply.writeTypedList(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements aidlservice.IMyAidlInterface
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public java.lang.String getText() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getText, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getText();
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void placeCall(java.lang.String number) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(number);
          boolean _status = mRemote.transact(Stub.TRANSACTION_placeCall, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().placeCall(number);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public java.util.List<java.lang.String> getList() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.util.List<java.lang.String> _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getList, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getList();
          }
          _reply.readException();
          _result = _reply.createStringArrayList();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      //parcelables

      @Override public java.util.List<aidlservice.RecentModel> getAllRecents() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.util.List<aidlservice.RecentModel> _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getAllRecents, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getAllRecents();
          }
          _reply.readException();
          _result = _reply.createTypedArrayList(aidlservice.RecentModel.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public java.util.List<aidlservice.ContactModel> getAllContacts() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.util.List<aidlservice.ContactModel> _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getAllContacts, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getAllContacts();
          }
          _reply.readException();
          _result = _reply.createTypedArrayList(aidlservice.ContactModel.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public java.util.List<aidlservice.FavoriteModel> getAllFavorites() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.util.List<aidlservice.FavoriteModel> _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getAllFavorites, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getAllFavorites();
          }
          _reply.readException();
          _result = _reply.createTypedArrayList(aidlservice.FavoriteModel.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static aidlservice.IMyAidlInterface sDefaultImpl;
    }
    static final int TRANSACTION_getText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_placeCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_getList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_getAllRecents = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getAllContacts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_getAllFavorites = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    public static boolean setDefaultImpl(aidlservice.IMyAidlInterface impl) {
      // Only one user of this interface can use this function
      // at a time. This is a heuristic to detect if two different
      // users in the same process use this function.
      if (Stub.Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static aidlservice.IMyAidlInterface getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public java.lang.String getText() throws android.os.RemoteException;
  public void placeCall(java.lang.String number) throws android.os.RemoteException;
  public java.util.List<java.lang.String> getList() throws android.os.RemoteException;
  //parcelables

  public java.util.List<aidlservice.RecentModel> getAllRecents() throws android.os.RemoteException;
  public java.util.List<aidlservice.ContactModel> getAllContacts() throws android.os.RemoteException;
  public java.util.List<aidlservice.FavoriteModel> getAllFavorites() throws android.os.RemoteException;
}
