package AISS.vimeo.services;

import AISS.vimeo.model.Channel.Channel;
import AISS.vimeo.model.VMTransform;
import AISS.vimeo.model.VM.VMChannel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChannelServiceTest {

    @Autowired
    ChannelService service;

    @Test
    @DisplayName("Get 1 channel")
    void findChannel(){
        Channel channel = service.findChannel("staffpicks","10","10");
        System.out.println(VMTransform.ofChannel(channel));
    }


    @Test
    @DisplayName("Create 1 channel")
    void createChannel() {
        Channel channel = service.findChannel("staffpicks","1","1");
        VMChannel channelVm = VMTransform.ofChannel(channel);
        VMChannel channelVmCreated = service.createChannel(channelVm);
        System.out.println(channelVmCreated);
    }
}