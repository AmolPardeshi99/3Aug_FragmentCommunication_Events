package com.example.a3aug_fragmentcommunication_events;

import android.os.Bundle;

public interface FragmentCommunicationListener {

    void dataFromEventDetails(Bundle bundle);
    void dataFromTimeDetails(Bundle bundle);
    void dataFromPrisePage(Bundle bundle);

}
