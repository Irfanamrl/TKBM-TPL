package id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Manga> selected = new MutableLiveData<>();

    public void setSelected(Manga item) {
        selected.setValue(item);
    }

    public MutableLiveData<Manga> getSelected() {
        return selected;
    }
}