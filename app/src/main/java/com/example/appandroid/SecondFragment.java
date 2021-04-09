package com.example.appandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {





    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button).setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment));

        view.findViewById(R.id.button).setOnClickListener(view1 -> plusCount());

        view.findViewById(R.id.button2).setOnClickListener(view1 -> plusCount());


        model = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        count = model.getCompte();
        modifyTextView(count);
    }

    private void minusCount(){
        if(count>0){
            count--;
        }
        model.setCompte(count);
        modifyTextView(count);
    }

    private void plusCount(){
        count++;
        model.setCompte(count);
        modifyTextView(count);
    }

    private void razCount(){
        count=0;
        model.setCompte(count);
        modifyTextView(count);
    }

    private void modifyTextView(int count){
        TextView t = getView().findViewById(R.id.countText);
        t.setText(String.valueOf(count));
    }
}