package com.lucapp.ui.main.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lucapp.CardView;
import com.lucapp.MyAdapter;
import com.lucapp.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<CardView> itemList;
    private RecyclerView recyclerView;
    public static MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment_recycler_view_card, container, false);

        itemList = new ArrayList<>();

        //populate the itemList (maybe can be made auto but the ID mess me up)
        {
            itemList.add(new CardView(R.drawable.banjo_and_kazooie, "Banjo and Kazooie"));
            itemList.add(new CardView(R.drawable.bayonetta, "Bayonetta"));
            itemList.add(new CardView(R.drawable.bowser, "Bowser"));
            itemList.add(new CardView(R.drawable.bowser_jr, "Bowser Jr"));
            itemList.add(new CardView(R.drawable.byleth, "Byleth"));
            itemList.add(new CardView(R.drawable.captain_falcon, "Captain Falcon"));
            itemList.add(new CardView(R.drawable.chrom, "Chrom"));
            itemList.add(new CardView(R.drawable.cloud, "Cloud"));
            itemList.add(new CardView(R.drawable.corrin, "Corrin"));
            itemList.add(new CardView(R.drawable.daisy, "Daisy"));
            itemList.add(new CardView(R.drawable.dark_pit, "Dark Pit"));
            itemList.add(new CardView(R.drawable.dark_samus, "Dark Samus"));
            itemList.add(new CardView(R.drawable.diddy_kong, "Diddy Kong"));
            itemList.add(new CardView(R.drawable.donkey_kong, "Donkey Kong"));
            itemList.add(new CardView(R.drawable.dr_mario, "Dr. Mario"));
            itemList.add(new CardView(R.drawable.duck_hunt, "Duck Hunt"));
            itemList.add(new CardView(R.drawable.falco, "Falco"));
            itemList.add(new CardView(R.drawable.fox, "Fox"));
            itemList.add(new CardView(R.drawable.ganondorf, "Ganondorf"));
            itemList.add(new CardView(R.drawable.greninja, "Greninja"));
            itemList.add(new CardView(R.drawable.hero, "Hero"));
            itemList.add(new CardView(R.drawable.ice_climbers, "Ice Climbers"));
            itemList.add(new CardView(R.drawable.ike, "Ike"));
            itemList.add(new CardView(R.drawable.incineroar, "Incineroar"));
            itemList.add(new CardView(R.drawable.inkling, "Inkling"));
            itemList.add(new CardView(R.drawable.isabelle, "Isabelle"));
            itemList.add(new CardView(R.drawable.jigglypuff, "Jigglypuff"));
            itemList.add(new CardView(R.drawable.joker, "Joker"));
            itemList.add(new CardView(R.drawable.kazuya, "Kazuya"));
            itemList.add(new CardView(R.drawable.ken, "Ken"));
            itemList.add(new CardView(R.drawable.king_dedede, "King Dedede"));
            itemList.add(new CardView(R.drawable.king_k_rool, "King K. Rool"));
            itemList.add(new CardView(R.drawable.kirby, "Kirby"));
            itemList.add(new CardView(R.drawable.link, "Link"));
            itemList.add(new CardView(R.drawable.little_mac, "Little Mac"));
            itemList.add(new CardView(R.drawable.lucario, "Lucario"));
            itemList.add(new CardView(R.drawable.lucas, "Lucas"));
            itemList.add(new CardView(R.drawable.lucina, "Lucina"));
            itemList.add(new CardView(R.drawable.luigi, "Luigi"));
            itemList.add(new CardView(R.drawable.mario, "Mario"));
            itemList.add(new CardView(R.drawable.marth, "Marth"));
            itemList.add(new CardView(R.drawable.mega_man, "Mega Man"));
            itemList.add(new CardView(R.drawable.meta_knight, "Meta Knight"));
            itemList.add(new CardView(R.drawable.mewtwo, "Mewtwo"));
            itemList.add(new CardView(R.drawable.mii_brawler, "Mii Brawler"));
            itemList.add(new CardView(R.drawable.mii_gunner, "Mii Gunner"));
            itemList.add(new CardView(R.drawable.mii_swordfighter, "Mii Swordfighter"));
            itemList.add(new CardView(R.drawable.minmin, "Minmin"));
            itemList.add(new CardView(R.drawable.mr_game_and_watch, "Mr Game & Watch"));
            itemList.add(new CardView(R.drawable.ness, "Ness"));
            itemList.add(new CardView(R.drawable.olimar, "Olimar"));
            itemList.add(new CardView(R.drawable.pac_man, "Pac Man"));
            itemList.add(new CardView(R.drawable.palutena, "Palutena"));
            itemList.add(new CardView(R.drawable.peach, "Peach"));
            itemList.add(new CardView(R.drawable.pichu, "Pichu"));
            itemList.add(new CardView(R.drawable.pikachu, "Pikachu"));
            itemList.add(new CardView(R.drawable.piranha_plant, "Piranha Plant"));
            itemList.add(new CardView(R.drawable.pit, "Pit"));
            itemList.add(new CardView(R.drawable.pokemon_trainer, "Pokemon Trainer"));
            itemList.add(new CardView(R.drawable.pyra, "Pyra/Mythra"));
            itemList.add(new CardView(R.drawable.richter, "Richter"));
            itemList.add(new CardView(R.drawable.ridley, "Ridley"));
            itemList.add(new CardView(R.drawable.rob, "R.O.B."));
            itemList.add(new CardView(R.drawable.robin, "Robin"));
            itemList.add(new CardView(R.drawable.rosalina_and_luma, "Rosalina & Luma"));
            itemList.add(new CardView(R.drawable.roy, "Roy"));
            itemList.add(new CardView(R.drawable.ryu, "Ryu"));
            itemList.add(new CardView(R.drawable.samus, "Samus"));
            itemList.add(new CardView(R.drawable.sephiroth, "Sephiroth"));
            itemList.add(new CardView(R.drawable.sheik, "Sheik"));
            itemList.add(new CardView(R.drawable.shulk, "Shulk"));
            itemList.add(new CardView(R.drawable.simon, "Simon"));
            itemList.add(new CardView(R.drawable.snake, "Snake"));
            itemList.add(new CardView(R.drawable.sonic, "Sonic"));
            itemList.add(new CardView(R.drawable.steve, "Steve"));
            itemList.add(new CardView(R.drawable.terry, "Terry"));
            itemList.add(new CardView(R.drawable.toon_link, "Toon Link"));
            itemList.add(new CardView(R.drawable.villager, "Villager"));
            itemList.add(new CardView(R.drawable.wario, "Wario"));
            itemList.add(new CardView(R.drawable.wii_fit_trainer, "Wii Fit Trainer"));
            itemList.add(new CardView(R.drawable.wolf, "Wolf"));
            itemList.add(new CardView(R.drawable.yoshi, "Yoshi"));
            itemList.add(new CardView(R.drawable.young_link, "Young Link"));
            itemList.add(new CardView(R.drawable.zelda, "Zelda"));
            itemList.add(new CardView(R.drawable.zero_suit_samus, "Zero Suit Samus"));
        }// metodo statico

        //adapter for the recyclerView
        adapter = new MyAdapter(itemList);
        buildRecyclerView(root);

        adapter.setOnItemClickListener((new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //do the click method of the selected card
                itemList.get(position).click(root.getContext());
            }
        }));
        return root;
    }

    private void buildRecyclerView(View root) {
        recyclerView = root.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        //set the row of 3 elements each
        layoutManager = new GridLayoutManager(root.getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}