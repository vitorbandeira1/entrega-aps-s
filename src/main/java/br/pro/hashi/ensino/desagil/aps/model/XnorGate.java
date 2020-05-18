package br.pro.hashi.ensino.desagil.aps.model;

public class XnorGate extends Gate {
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;
    private final NandGate nand5;

    public XnorGate() {
        super("XNOR", 2);
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
        NandGate nand4 = new NandGate();
        nand5 = new NandGate();


        nand2.connect(1, nand1);
        nand3.connect(0, nand1);
        nand4.connect(0, nand2);
        nand4.connect(1, nand3);

        nand5.connect(0, nand4);
        nand5.connect(1, nand4);


    }

    public boolean read() {
        return nand5.read();
    }


    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex) {
            case 0:
                nand1.connect(0, emitter);
                nand2.connect(0, emitter);
                break;
            case 1:
                nand1.connect(1, emitter);
                nand3.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputIndex);
        }
    }
}
//        if (inputIndex < 0 || inputIndex > 1) {
//            throw new IndexOutOfBoundsException(inputIndex);
//        }
//
//
//        if (inputIndex == 0) {
//            nand1.connect(0, emitter);
//            nand2.connect(0, emitter);
//        }
//        if (inputIndex == 1) {
//            nand1.connect(1, emitter);
//            nand3.connect(1, emitter);
//        }
//
//    }
//
//}
