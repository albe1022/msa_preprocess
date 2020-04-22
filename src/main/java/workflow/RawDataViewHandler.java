package workflow;

import workflow.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RawDataViewHandler {


    @Autowired
    private RawDataRepository rawDataRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDataSaved_then_CREATE_1 (@Payload DataSaved dataSaved) {
        try {
            if (dataSaved.isMe()) {
                // view 객체 생성
                RawData rawData = new RawData();
                // view 객체에 이벤트의 Value 를 set 함
                rawData.setId(dataSaved.getId());
                rawData.setDataType(dataSaved.getDataType());
                // view 레파지 토리에 save
                rawDataRepository.save(rawData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}