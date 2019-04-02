v0.24 :
	   中测第一组数据WA，原因是Main线程过早结束，保持住到两个分线程结束即可。
   	t.join()方法阻塞调用此方法的线程(calling thread)，直到线程t完成，此线程再继续；通常用于在main()主线程内，等待其它线程完成再结束main()主线程。

   	使用txt文件代替键盘输入：在System.in前加上：
        
        try {
            FileInputStream input = new FileInputStream("F:\\Java_worksapce\\Elevator\\test.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }