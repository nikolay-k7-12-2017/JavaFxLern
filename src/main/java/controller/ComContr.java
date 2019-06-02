package controller;

import applicationComForm.ControllerComMyPort;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;


import java.util.concurrent.atomic.AtomicInteger;

public class ComContr {
    private SerialPort serialPort;
     String data;
    String text2;

    private ControllerComMyPort controllerComMyPort;
      AtomicInteger atomicInt =new AtomicInteger(0);

    public ComContr( ControllerComMyPort controllerComMyPort) {
        this.controllerComMyPort = controllerComMyPort;
    }

    public String[] searcheComPort() {
        String[] portNames = SerialPortList.getPortNames();
       /* for (String portName : portNames) {
            System.out.println(portName);
        }*/
        return portNames;
    }

    public void initComPort(String comPort1) {
        closePort();

        serialPort = new SerialPort(comPort1);
        System.out.println("init copPort1: "+ comPort1);
         controllerComMyPort.setTextarea2("jajajaaj7777");

        System.out.println("serialPort.getPortName(): "+serialPort.getPortName());
        System.out.println("text1: "+comPort1);
        System.out.println(" serialPort.isOpened(): "+ serialPort.isOpened());

        System.out.println("serialPort.getPortName(): "+serialPort.getPortName());
        System.out.println("controllerComMyPort.getComComboBox(): "+controllerComMyPort.getComComboBox());

//        controllerComMyPort.setTextarea2("Poluchilos");

        try {
            //Открываем порт
            serialPort.openPort();
            //Выставляем параметры
//                controllerComMyPort.setTextarea1("jajajaj");
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //Включаем аппаратное управление потоком
    //      serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
    //             SerialPort.FLOWCONTROL_RTSCTS_OUT);

            serialPort.setEventsMask(SerialPort.MASK_RXCHAR);

            serialPort.addEventListener(new ReadComPort(serialPort,controllerComMyPort));

              //  serialPort.closePort();
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }

    }


    public void closePort()  {
        try {
            if(serialPort != null) {
                if(serialPort.isOpened()) {
                    serialPort.closePort();
                }
            }
        } catch (SerialPortException ex) {
            System.err.print(ex);
            System.out.println("Ошибка закрытия Com порта");
        }
    }
}