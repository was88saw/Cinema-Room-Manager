interface Flying {
    // returns height of flying in meters
    int getHeight();

    // implements a default method getHeightInKm that returns height of flying in km as int type
    public default int getHeightInKm(){
        return (int)getHeight() / 1000;
    }
}