package id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;

import id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab.R;
import id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab.databinding.FragmentMangaListBinding;

import java.util.ArrayList;
import java.util.List;

public class MangaListFragment extends Fragment {
    private FragmentMangaListBinding binding;
    private DetailsFragment detailsFragment = new DetailsFragment();

    public MangaListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_manga_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<Manga> list = new ArrayList<>();
        list.add(new Manga("Naruto", "Masashi Kishimoto", "welve years before the start of the series, the Nine-Tails attacked Konohagakure destroying much of the village and taking many lives. The leader of the village, the Fourth Hokage, sacrificed his life to seal the Nine-Tails into a newborn, Naruto Uzumaki. Orphaned by the attack, Naruto was shunned by the villagers, who out of fear and anger, viewed him as the Nine-Tails itself. Though the Third Hokage outlawed speaking about anything related to the Nine-Tails, the children — taking their cues from their parents — inherited the same animosity towards Naruto. In his thirst to be acknowledged, Naruto vowed he would one day become the greatest Hokage the village had ever seen. "));
        list.add(new Manga("Yotsuba to!", "Azuma", "Yotsuba's daily life is full of adventure. She is energetic, curious, and a bit odd—odd enough to be called strange by her father as well as ignorant of many things that even a five-year-old should know. Because of this, the most ordinary experience can become an adventure for her. As the days progress, she makes new friends and shows those around her that every day can be enjoyable."));
        list.add(new Manga("I sold my life for ten thousand yen per year.", "Shouichi Taguchi", "Helpless and struggling for cash, 20-year-old Kusunoki sells the last of his possessions to buy food. Noticing his poverty, an old shop owner directs him to a store that supposedly purchases lifespan, time, and health. While not completely believing the man's words, Kusunoki nevertheless finds himself at the address out of desperation and curiosity.\n" +
                "\n" +
                "Kusunoki is crushed when he finds out the true monetary value of his lifespan—totaling a meager three hundred thousand yen. Deciding to sell the next 30 years of his life for ten thousand yen per year, Kusunoki is left with only three months to live. After heading home with the money, he is greeted by an unexpected visitor: the same store clerk he sold his lifespan to. She introduces herself as Miyagi, the one tasked with the job of observing him until the last three days of his life.\n" +
                "\n" +
                "Jumyou wo Kaitotte Moratta. Ichinen ni Tsuki, Ichimanen de. follows the remaining three months of Kusunoki's life as he confronts lingering regrets from the past and discovers what truly gives life value."));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        binding.recyclerView.setAdapter(adapter);
        adapter.setListener((v, position) -> {
            viewModel.setSelected(adapter.getItemAt(position));
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, detailsFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}
