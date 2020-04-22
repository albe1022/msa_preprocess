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
public class RawDataListViewHandler {


    @Autowired
    private RawDataListRepository rawDataListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDataSaved_then_CREATE_1 (@Payload DataSaved dataSaved) {
        try {
            if (dataSaved.isMe()) {
                // view 객체 생성
                RawDataList rawDataList = new RawDataList();
                // view 객체에 이벤트의 Value 를 set 함
                rawDataList.setId(dataSaved.getId());
                rawDataList.setDataType(dataSaved.getDataType());
                // view 레파지 토리에 save
                rawDataListRepository.save(rawDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}