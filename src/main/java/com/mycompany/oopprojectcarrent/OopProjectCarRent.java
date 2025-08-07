package com.mycompany.oopprojectcarrent;

import static com.mycompany.oopprojectcarrent.OopProjectCarRent.carList;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class OopProjectCarRent extends JFrame {
    static ArrayList<Car> carList = new ArrayList<>();
   // data fields 
    Car x;
    Client person;
    JComboBox<String> carNames,busNames;
    JComboBox<Car> chooseRentCar,chooseReturnCar;
    CardLayout cardLayout;
    public static JPanel P0,P1,P2,P3,P4,P5,P6;
    public static JLabel P1_pic;
    JButton btRentCar,btReturnCar,btAddCar,btSeeCars,btSeeHistory;                     //bt for P1
    JButton btRentaCar,btRentBack;                                                     //bt for p2
    JButton btP3return,btP3Back;                                                       //bt for p3
    JButton btNormal,btBus,btAddNormal,btAddBus,btNormalBack,btBusBack;                //bt for p4
    JButton btP5Back;                                                                  //bt for p5
    JButton btP6Back,btP6List;                                                         //bt for p6
    JLabel normalMsgBox,busMsgBox,rentCarMsgBox,returnCarMsgBox;
    JTextArea showCars,showTransactions;
    JTextField normalColortxt,normalIDtxt,normalChassistxt,normalRegPricetxt,normalDiscounttxt,normalMaxAllowedRenttxt,normalMaxRentDurtxt; 
    JTextField busColortxt,busIDtxt,busChassistxt,busRegPricetxt,busMaxAllowedRenttxt,busCapacitytxt; 
    JTextField clientNametxt,clientSNNtxt,clientPhoneNumtxt,clientAddresstxt;
    JTextField d1daytxt,d1monthtxt,d1yeartxt,d2daytxt,d2monthtxt,d2yeartxt;
    Date date1,date2;
   
    public OopProjectCarRent(String s) throws IOException{
        
        addWindowListener(new WindowListener() {
      /**
       * Handler for window deiconified event
       * Invoked when a window is changed from a minimized
       * to a normal state.
       */
      @Override
      public void windowDeiconified(WindowEvent event) {
        System.out.println("Window deiconified");
      }

      /**
       * Handler for window iconified event
       * Invoked when a window is changed from a normal to a
       * minimized state. For many platforms, a minimized window
       * is displayed as the icon specified in the window's
       * iconImage property.
       */
      @Override
      public void windowIconified(WindowEvent event) {
        System.out.println("Window iconified");
      }

      /**
       * Handler for window activated event
       * Invoked when the window is set to be the user's
       * active window, which means the window (or one of its
       * subcomponents) will receive keyboard events.
       */
      @Override
      public void windowActivated(WindowEvent event) {
        System.out.println("Window activated");
      }

      /**
       * Handler for window deactivated event
       * Invoked when a window is no longer the user's active
       * window, which means that keyboard events will no longer
       * be delivered to the window or its subcomponents.
       */
      @Override
      public void windowDeactivated(WindowEvent event) {
        System.out.println("Window deactivated");
      }

      /**
       * Handler for window opened event
       * Invoked the first time a window is made visible.
       */
      @Override
      public void windowOpened(WindowEvent event) {
        System.out.println("Window opened");
      }

      /**
       * Handler for window closing event
       * Invoked when the user attempts to close the window
       * from the window's system menu.  If the program does not
       * explicitly hide or dispose the window while processing
       * this event, the window close operation will be cancelled.
       */
      @Override
      public void windowClosing(WindowEvent event) {
        //streamObjectsToFile(carList, "Car.dat");
        for (Car c : carList) {
            try {
                ObjectOutputStream Cout = new ObjectOutputStream(new FileOutputStream("Car.dat"));
                Cout.writeObject(carList);
                Cout.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OopProjectCarRent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OopProjectCarRent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Window closing");
      }

      /**
       * Handler for window closed event
       * Invoked when a window has been closed as the result
       * of calling dispose on the window.
       */
      @Override
      public void windowClosed(WindowEvent event) {
        System.out.println("Window closed");
      }
      });
        
        
        
        
        
        
        
        
        
        //main panel(the parent panel)
        setTitle(s);
        P0 = new JPanel();
        cardLayout = new CardLayout();
        P0.setLayout(cardLayout);
        P0.setBackground(Color.black);
        P0.setBorder(new EmptyBorder(10,10,10,10));
        
        
        //all panels initialozation + setting names + adding them tp the parent card layout panel P0
        P1 = new JPanel(new BorderLayout());P2 = new JPanel(new BorderLayout());P3 = new JPanel(new BorderLayout());P4 = new JPanel(new BorderLayout());P5 = new JPanel(new BorderLayout());P6 = new JPanel(new BorderLayout());
        P1.setName("Panel 1");P2.setName("Panel 2");P3.setName("Panel 3");P4.setName("Panel 4");P5.setName("Panel 5");P6.setName("Panel 6");
        P0.add(P1, "Panel 1");P0.add(P2, "Panel 2");P0.add(P3, "Panel 3");P0.add(P4, "Panel 4");P0.add(P5, "Panel 5");P0.add(P6, "Panel 6");
        add(P0);
        
        
        
        
        
        
        //p1:start up panel
        
        P1.setBorder(new LineBorder(Color.BLACK,3));
        JPanel P1_name = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        JLabel compName = new JLabel("-----  GOLDEN   CAR   RENTAL  -----");
        Font font = new Font("Arial", Font.PLAIN, 30);
        compName.setFont(font);
        P1_name.add(compName);
        P1.add(P1_name,NORTH);
        
        JPanel P1_picpanel = new JPanel(new BorderLayout());
        P1.add(P1_picpanel,CENTER);
        P1_pic = new JLabel();
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\ahmad\\OneDrive\\Documents\\NetBeansProjects\\oopProjectCarRent\\src\\main\\java\\com\\mycompany\\oopprojectcarrent\\wfwefw.JPG");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        P1_pic.setIcon(imageIcon);
        P1_picpanel.add(P1_pic,CENTER);
        


        
        
        
        
        
        //buttons to navigate throygh the program
        
        JPanel P1_bt = new JPanel(new GridLayout(1,5,5,5));
        btRentCar = new JButton("Rent a car");btReturnCar = new JButton("Return a car");btAddCar = new JButton("Add a car");btSeeCars = new JButton("See cars");btSeeHistory = new JButton("Check history");
        P1_bt.add(btRentCar);P1_bt.add(btReturnCar);P1_bt.add(btAddCar);P1_bt.add(btSeeCars);P1_bt.add(btSeeHistory);
        P1_bt.setBorder(new EmptyBorder(5,5,5,5));
        P1.add(P1_bt,SOUTH);
        
        btRentCar.addActionListener(new setP2());
        btReturnCar.addActionListener(new setP3());
        btAddCar.addActionListener(new setP4());
        btSeeCars.addActionListener(new setP5());
        btSeeHistory.addActionListener(new setP6());
        P1.setVisible(true);
        
        
        
        
        
        
        
        
        //p2:rent car panel
        
        JPanel P2info = new JPanel(new GridLayout(7,2,5,5));P2.add(P2info);
        JPanel P2top = new JPanel(new FlowLayout(FlowLayout.LEFT));P2.add(P2top,NORTH);
        JLabel createClientlbl = new JLabel("Enter the following information:");createClientlbl.setFont(font);P2top.add(createClientlbl);
        JLabel clientlbl = new JLabel("Regarding the client:");P2info.add(clientlbl);P2info.add(new JPanel());
        JLabel namelbl = new JLabel("Name:");P2info.add(namelbl);
        clientNametxt = new JTextField();P2info.add(clientNametxt);
        JLabel SNNlbl = new JLabel("SNN:");P2info.add(SNNlbl);
        clientSNNtxt = new JTextField();P2info.add(clientSNNtxt);
        JLabel phoneNumlbl = new JLabel("Phone number:");P2info.add(phoneNumlbl);
        clientPhoneNumtxt = new JTextField();P2info.add(clientPhoneNumtxt);
        JLabel addresslbl = new JLabel("Address:");P2info.add(addresslbl);
        clientAddresstxt = new JTextField();P2info.add(clientAddresstxt);
        P2info.add(new JPanel());P2info.add(new JPanel());
        JLabel chooseCarlbl = new JLabel("Choose a car:");P2info.add(chooseCarlbl);
        chooseRentCar = new JComboBox<>();P2info.add(chooseRentCar);
        P2.add(P2info);
        
        JPanel P2bt = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rentCarMsgBox = new JLabel();P2bt.add(rentCarMsgBox);
        btRentaCar = new JButton("Rent");P2bt.add(btRentaCar);
        btRentBack = new JButton("back");P2bt.add(btRentBack);
        btRentaCar.addActionListener(new RentCar());
        btRentBack.addActionListener(new btBACK());
        P2.add(P2bt,SOUTH);
        
        
        
        
        
        
        //p3:return car panel
        
        JPanel P3return = new JPanel(new GridLayout(2,1,5,5));P3.add(P3return,CENTER);
        JLabel returntxt = new JLabel("Choose the car to return:");returntxt.setFont(font);P3return.add(returntxt);
        chooseReturnCar = new JComboBox<>();P3return.add(chooseReturnCar);
        JPanel P3bt = new JPanel(new FlowLayout(FlowLayout.RIGHT));P3.add(P3bt,SOUTH);
        returnCarMsgBox = new JLabel();P3bt.add(returnCarMsgBox);
        btP3return = new JButton("Return");P3bt.add(btP3return);
        btP3Back = new JButton("Back");P3bt.add(btP3Back);
        btP3return.addActionListener(new ReturnCar());
        btP3Back.addActionListener(new btBACK());
        

        
        
        
        
        
        
        //p4:add car panel/normal car
        
        JPanel P4intro = new JPanel(new BorderLayout());
        JPanel P4Normal = new JPanel(new BorderLayout());
        JPanel P4Bus = new JPanel(new BorderLayout());
        P4Normal.setName("PanelP4Normal");
        P0.add(P4Normal, "PanelP4Normal");
        P4Bus.setName("PanelP4Bus");
        P0.add(P4Bus, "PanelP4Bus");

        JPanel P4introlbl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel addCarlbl = new JLabel("Do you wish to add a normal car or a bus?");
        addCarlbl.setFont(font);
        P4introlbl.add(addCarlbl,NORTH);
        P4intro.add(P4introlbl,NORTH);
        JPanel P4introbt = new JPanel(new GridLayout(1,2,5,5));
        btNormal = new JButton("A Normal Car");
        btBus = new JButton("A Bus");
        P4introbt.add(btNormal);
        P4introbt.add(btBus);
        btNormal.setFont(font);btBus.setFont(font);
        P4intro.add(P4introbt);
        P4.add(P4intro,CENTER);
        btNormal.addActionListener(new addNormalbt());
        btBus.addActionListener(new addBusbt());
        
        //for p4normal
        
        JPanel P4Normallbl = new JPanel(new FlowLayout());
        JLabel P4normaltxt = new JLabel("Enter the following information of the new normal car:");
        P4normaltxt.setFont(font);
        P4Normallbl.add(P4normaltxt,CENTER);
        P4Normal.add(P4Normallbl,NORTH);
        JPanel normalInfo = new JPanel(new GridLayout(8,2,5,5));
        P4Normal.add(normalInfo,CENTER);
        
        JLabel carlbl = new JLabel("Name :");normalInfo.add(carlbl);
        String carBrands = "-select- Abarth AC Aixam Alfa-Romeo Alpine Asia Aston-Martin Audi Austin BAC Bentley BMW Bristol Bugatti BYD Cadillac Caterham Chevrolet Chrysler Citroen Coleman Milne Corvette Cupra Dacia Daewoo Daihatsu Daimler DFSK Dodge-DS Eagle Farbio FBS Ferrari Fiat Ford FSO Genesis GWM ORA Honda Hummer Hyundai INEOS Infiniti Invicta Isuzu Jaguar Jeep Jensen Kia KTM Lada Lamborghini Lancia Land-Rover LEVC Lexus Ligier Lotus LTI MAHINDRA Marcos Marlin Maserati MAXUS Maybach Mazda McLaren Mercedes-AMG Mercedes-Benz MG MIA Microcar MINI Mitsubishi MOKE Morgan Nissan Noble Opel Perodua Peugeot PGO Polestar Porsche PRINDIVILLE Prindiville Proton Reliant Renault Rolls-Royce Rover Saab San SAO SEAT Skoda Smart SsangYong Subaru Suzuki Talbot TD Tesla Toyota TVR Vauxhall Volkswagen Volvo Westfield Yugo";
        String[] CARNAMES = carBrands.split(" ");
        carNames = new JComboBox<>(CARNAMES);
        normalInfo.add(carNames);
        JLabel normalColorlbl = new JLabel ("Color :");normalInfo.add(normalColorlbl);
        normalColortxt = new JTextField();normalInfo.add(normalColortxt);
        JLabel normalIDlbl = new JLabel("ID :");normalInfo.add(normalIDlbl);
        normalIDtxt = new JTextField();normalInfo.add(normalIDtxt);
        JLabel normalChassislbl = new JLabel("Chassis :");normalInfo.add(normalChassislbl);
        normalChassistxt = new JTextField();normalInfo.add(normalChassistxt);
        JLabel normalRegPricelbl = new JLabel("Regular renting price :");normalInfo.add(normalRegPricelbl);
        normalRegPricetxt = new JTextField();normalInfo.add(normalRegPricetxt);
        JLabel normalDiscountlbl = new JLabel("Discount ammount :");normalInfo.add(normalDiscountlbl);
        normalDiscounttxt = new JTextField();normalInfo.add(normalDiscounttxt);
        JLabel normalMaxAllowedRentlbl = new JLabel("Max times allowed to be rented :");normalInfo.add(normalMaxAllowedRentlbl);
        normalMaxAllowedRenttxt = new JTextField();normalInfo.add(normalMaxAllowedRenttxt);
        JLabel normalMaxRentDurlbl = new JLabel("Max Rent Duration :");normalInfo.add(normalMaxRentDurlbl);
        normalMaxRentDurtxt = new JTextField();normalInfo.add(normalMaxRentDurtxt);
        
        JPanel P4normalButtoms = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        normalMsgBox = new JLabel();
        btAddNormal = new JButton("Add the car/save");btAddNormal.addActionListener(new saveNewCar());
        btNormalBack = new JButton("back");btNormalBack.addActionListener(new btBACK());
        P4normalButtoms.add(normalMsgBox);P4normalButtoms.add(btAddNormal);P4normalButtoms.add(btNormalBack);
        P4Normal.add(P4normalButtoms,SOUTH);
        
        //p4:add car panel/bus
        
        JPanel P4Buslbl = new JPanel(new FlowLayout());
        JLabel P4Bustxt = new JLabel("Enter the following information of the new bus:");
        P4Bustxt.setFont(font);
        P4Buslbl.add(P4Bustxt,CENTER);
        P4Bus.add(P4Buslbl,NORTH);
        JPanel BusInfo = new JPanel(new GridLayout(7,2,5,5));
        P4Bus.add(BusInfo,CENTER);
        
        JLabel buslbl = new JLabel("Name :");BusInfo.add(buslbl);
        String[] BUSNAMES  = {"-select-","Ashok Leyland", "Alexander Dennis", "Blue Bird Corporation", "BYD Company", "Collins Industries", "Eicher Motors", "Gillig", "Golden Dragon", "Higer Bus", "IC Bus", "Iveco Bus", "King Long", "MAN SE", "Mercedes-Benz Group", "Navistar, Inc", "Prevost Car", "REV Group", "Scania", "Thomas Built Buses", "Van Hool", "Volvo Buses", "Yutong", "Zhongtong Bus"};
        busNames = new JComboBox<>(BUSNAMES);
        BusInfo.add(busNames);
        JLabel busColorlbl = new JLabel ("Color :");BusInfo.add(busColorlbl);
        busColortxt = new JTextField();BusInfo.add(busColortxt);
        JLabel busIDlbl = new JLabel("ID :");BusInfo.add(busIDlbl);
        busIDtxt = new JTextField();BusInfo.add(busIDtxt);
        JLabel busChassislbl = new JLabel("Chassis :");BusInfo.add(busChassislbl);
        busChassistxt = new JTextField();BusInfo.add(busChassistxt);
        JLabel busRegPricelbl = new JLabel("Regular renting price :");BusInfo.add(busRegPricelbl);
        busRegPricetxt = new JTextField();BusInfo.add(busRegPricetxt);
        JLabel busMaxAllowedRentlbl = new JLabel("Max times allowed to be rented :");BusInfo.add(busMaxAllowedRentlbl);
        busMaxAllowedRenttxt = new JTextField();BusInfo.add(busMaxAllowedRenttxt);
        JLabel busCapacity = new JLabel("Capacity :");BusInfo.add(busCapacity);
        busCapacitytxt = new JTextField();BusInfo.add(busCapacitytxt);
        
        JPanel P4BusButtoms = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        busMsgBox = new JLabel();
        btAddBus = new JButton("Add the bus/save");btAddBus.addActionListener(new saveNewBus());
        btBusBack = new JButton("back");btBusBack.addActionListener(new btBACK());
        P4BusButtoms.add(busMsgBox);P4BusButtoms.add(btAddBus);P4BusButtoms.add(btBusBack);
        P4Bus.add(P4BusButtoms,SOUTH);
        
        
        
        
        
        
        
        //p5:see cars panel
        
        
        JPanel P5backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));P5.add(P5backPanel,SOUTH);
        btP5Back = new JButton("Back");P5backPanel.add(btP5Back);
        btP5Back.addActionListener(new btBACK());
        showCars = new JTextArea();P5.add(showCars,CENTER);
        showCars.setEditable(false);
        
        
        
        
        
        
        
        //p6:see history panel
        
        JPanel P6backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));P6.add(P6backPanel,SOUTH);
        btP6Back = new JButton("Back");P6backPanel.add(btP6Back);
        btP6Back.addActionListener(new btBACK());
        showTransactions = new JTextArea();P6.add(showTransactions,CENTER);
        showTransactions.setEditable(false);        
        
        JPanel P6main = new JPanel(new BorderLayout());P6.add(P6main,NORTH);
        JLabel P6lbl = new JLabel("Enter two dates to list the transactions between them:");P6main.add(P6lbl,NORTH);
        JPanel P6dates = new JPanel(new GridLayout(3,4,5,5));P6main.add(P6dates,CENTER);
        
        btP6List = new JButton("List");P6dates.add(btP6List); btP6List.addActionListener(new btListTrans());
        JLabel monthlbl = new JLabel("Month");P6dates.add(monthlbl);
        JLabel daylbl = new JLabel("Day");P6dates.add(daylbl);
        JLabel yearlbl = new JLabel("Year");P6dates.add(yearlbl);
        JLabel d1lbl = new JLabel("Date 1:");P6dates.add(d1lbl);
        d1monthtxt = new JTextField();P6dates.add(d1monthtxt);
        d1daytxt = new JTextField();P6dates.add(d1daytxt);        
        d1yeartxt = new JTextField();P6dates.add(d1yeartxt);
        JLabel d2lbl = new JLabel("Date 2:");P6dates.add(d2lbl);
        d2monthtxt = new JTextField();P6dates.add(d2monthtxt);
        d2daytxt = new JTextField();P6dates.add(d2daytxt);     
        d2yeartxt = new JTextField();P6dates.add(d2yeartxt);
        
        
        
        
        
        
    }
    
    
    public class setP2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).isAvailable() && (carList.get(i).numberOfTimesRented<carList.get(i).maxAllowedRenting)){
                    chooseRentCar.addItem(carList.get(i));
                }
            }
            if(chooseRentCar.getItemCount() == 0){
                rentCarMsgBox.setText("Sorry, no cars available.");
            }

            
            cardLayout.show(P0, "Panel 2");
        }

    }
    public class setP3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < carList.size(); i++) {
                if (!carList.get(i).isAvailable()){
                    chooseReturnCar.addItem(carList.get(i));
                }
            }
            if(chooseReturnCar.getItemCount() == 0){
                returnCarMsgBox.setText("None of the cars are rented at the moment.");
            }
            
            
            
            cardLayout.show(P0, "Panel 3");
        }
        
    }
    public class setP4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(P0, "Panel 4");
        }
        
    }
    public class setP5 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        for (Car b : carList) {
        sb.append(b.toString()).append("\n\n");
        }
        String P5cars = sb.toString();//System.out.println(P5cars);
        
        
        showCars.setLineWrap(true); // enable line wrapping
        showCars.setWrapStyleWord(true); // wrap at whitespace
        showCars.setText(P5cars);
        
            cardLayout.show(P0, "Panel 5");
        }
        
    }
    public class setP6 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(P0, "Panel 6");
        }
        
    }          
    public class addNormalbt implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(P0, "PanelP4Normal");
        }
    }
    public class addBusbt implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(P0, "PanelP4Bus");
        }
        
    }
    public class saveNewCar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            

            //Exceptions for input 
        try {
        String nname = (String) carNames.getSelectedItem();
        String ncolor = normalColortxt.getText();
        int nID = Integer.parseInt(normalIDtxt.getText());
        int nchassis = Integer.parseInt(normalChassistxt.getText());
        double nregPrice = Double.parseDouble(normalRegPricetxt.getText());
        int ntimesAlowRent = Integer.parseInt(normalMaxAllowedRenttxt.getText());
        int nmaxDura = Integer.parseInt(normalMaxRentDurtxt.getText());
        double ndiscount  = Double.parseDouble(normalDiscounttxt.getText());
        Car x = new NormalCar(nmaxDura,ndiscount,nname,ncolor,nID,nchassis,nregPrice,ntimesAlowRent);        
        
        
            // check if the car already exist by the ID

        
        
                
            boolean carExists = false;
        for (Car c : carList) {
            if (c.ID == x.ID){
                normalMsgBox.setText("Car already exists.");
                carExists = true;
                break;
            }
        }
        if (!carExists) {
            carList.add(x);
            normalMsgBox.setText("Car successfully added.");
        }
                } catch (NumberFormatException ex) {
            // Handle the exception by displaying an error message or performing an alternative action
            normalMsgBox.setText("Invalid input! Please enter a valid infonmation."); 
        }
        
        
                
    }}
    public class saveNewBus implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
       //to display an invalid msg depending on the entry of the user      
        try{
        
        String bname = (String) busNames.getSelectedItem();
        String bcolor = busColortxt.getText();
        int bID = Integer.parseInt(busIDtxt.getText());
        int bchassis = Integer.parseInt(busChassistxt.getText());
        double bregPrice = Double.parseDouble(busRegPricetxt.getText());
        int btimesAlowRent = Integer.parseInt(busMaxAllowedRenttxt.getText());
        int bcapacity = Integer.parseInt(busCapacitytxt.getText());
        
        x = new Bus(bcapacity,bname,bcolor,bID,bchassis,bregPrice,btimesAlowRent); 
        
        
        
        
        // bus invalid input 

        boolean carExists = false;
                for (Car c : carList) {
                    if (c.ID == x.ID){
                        busMsgBox.setText("Bus already exists.");
                        carExists = true;
                        break;
                    }
                }
                if (!carExists) {
                    carList.add(x);
                    busMsgBox.setText("Bus successfully added.");
                }
                
        } catch (NumberFormatException ex){
            busMsgBox.setText("Invalid input! Please enter a valid infonmation.");
        }        
        
        }
        
    }
    public class btBACK implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            normalMsgBox.setText("");busMsgBox.setText("");rentCarMsgBox.setText("");returnCarMsgBox.setText("");
            normalColortxt.setText("");normalIDtxt.setText("");normalChassistxt.setText("");normalRegPricetxt.setText("");normalMaxAllowedRenttxt.setText("");normalDiscounttxt.setText("");normalMaxRentDurtxt.setText("");
            busColortxt.setText("");busIDtxt.setText("");busChassistxt.setText("");busRegPricetxt.setText("");busMaxAllowedRenttxt.setText("");busCapacitytxt.setText("");
            clientNametxt.setText("");clientSNNtxt.setText("");clientPhoneNumtxt.setText("");clientAddresstxt.setText("");showCars.setText("");
            chooseRentCar.removeAllItems();chooseReturnCar.removeAllItems();
            showCars.setText("");showTransactions.setText("");
            d1daytxt.setText("");d1monthtxt.setText("");d1yeartxt.setText("");d2daytxt.setText("");d2monthtxt.setText("");d2yeartxt.setText("");
            cardLayout.show(P0, "Panel 1");
            
            
        }
        
    }
    public class RentCar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            // invalid input in the client panel
            
            try{
            
            String Cname = clientNametxt.getText();
            int CSSN = Integer.parseInt(clientSNNtxt.getText());
            String  CPhoneNum = clientPhoneNumtxt.getText();
            String CAddress = clientAddresstxt.getText();
            person = new Client(Cname,CSSN,CPhoneNum,CAddress);
            
            
            
            
            
            ((Car) chooseRentCar.getSelectedItem()).transactions.add(new RentTransaction(((Car) chooseRentCar.getSelectedItem()),person));
            
            

            
            String s;
            if (chooseRentCar.getSelectedItem() instanceof NormalCar) s = "The renting price of the car is "+((NormalCar) chooseRentCar.getSelectedItem()).calculatePrice()+" ."+((Car) chooseRentCar.getSelectedItem()).rentCar();
            else s = "The renting price of the bus is "+((Bus) chooseRentCar.getSelectedItem()).calculatePrice()+" ."+((Car) chooseRentCar.getSelectedItem()).rentCar();
            
            rentCarMsgBox.setText(s);
            
            } catch (NumberFormatException ex1){
                rentCarMsgBox.setText("Invalid input! Please enter a valid infonmation.");
                
            }
            
            
        }
        
    }
    public class ReturnCar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = ((Car) chooseReturnCar.getSelectedItem()).returnCar();
            returnCarMsgBox.setText(s);
            
        }
        
    }
    public class btListTrans implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String d1day = d1daytxt.getText();
            String d1month = d1monthtxt.getText();
            String d1year = d1yeartxt.getText();
            String d2day = d2daytxt.getText();
            String d2month = d2monthtxt.getText();
            String d2year = d2yeartxt.getText();
            String date1str = d1month+"/"+d1day+"/"+d1year;
            String date2str = d2month+"/"+d2day+"/"+d2year;
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Define a date format
            // Exception for the date 
            try {
                date1 = dateFormat.parse(date1str);
            } catch (ParseException ex) {
                Logger.getLogger(OopProjectCarRent.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                date2 = dateFormat.parse(date2str);
            } catch (ParseException ex) {
                Logger.getLogger(OopProjectCarRent.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            StringBuilder sb = new StringBuilder();
            for (Car b : carList) {
            sb.append(b.displayTransDates(date1,date2)).append("\n\n");
            }
            String P6trans = sb.toString();
            if ((P6trans.replaceAll("\\s", "").length())==0)P6trans = "There are no transactions between these two dates.";


            showTransactions.setLineWrap(true); // enable line wrapping
            showTransactions.setWrapStyleWord(true); // wrap at whitespace
            showTransactions.setText(P6trans);

            
        }
        
    }

     

    
    
//    public static void streamObjectsToFile(List<?> objectList, String filePath) {
////        try ( ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
////            objectList.stream()
////                    .forEach(object -> {
////                        try {
////                            outputStream.writeObject(object);
////                            outputStream.close();
////                        } catch (IOException e) {
////                            e.printStackTrace();
////                        }
////                    });
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }   
//    public static void readDataFromFile() throws FileNotFoundException, IOException {
//        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Car.dat"))) {
//                try {
//                    Car car = (Car) inputStream.readObject();
//                    carList.add(car);
//                    inputStream.close();
//                } catch (Exception ex) {
//            } 
//        }
//            
//        
//    }
//    public static ArrayList<Car> readCarsFromFile(String fileName){
//        ArrayList<Car> carList = new ArrayList<>();
//        
//        try(FileInputStream fileIn = new FileInputStream(fileName);
//            ObjectInputStream objectIn = new ObjectInputStream(fileIn)){
//            while(fileIn.available() >0){
//                Car car = (Car) objectIn.readObject();
//                carList.add(car);
//            }
//        } catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        
//        return carList;
//    }
//    

     
     
     

    
        

     
     
     
     

    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //stream car from file
        try{
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("Car.dat"));
            carList = (ArrayList<Car>)objIn.readObject();
        }catch (IOException | ClassNotFoundException exp){}
        
        
        
        
        OopProjectCarRent frame = new OopProjectCarRent("Golden Car Rental");
        frame.setSize(800,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
    }
}
