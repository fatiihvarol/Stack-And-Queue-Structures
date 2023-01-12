package deneme;

import java.util.Random;

public class GameTest {
	public static void main(String[] args) throws Exception {
		Queue q1 = new Queue(1000);
		Queue q2 = new Queue(1000);
		Random rnd = new Random();

		boolean flag = true;
		int counter = 1;
		while (counter != 7) {
			flag = true;
			int random = rnd.nextInt(17) + 1;

			if (q1.isEmpty()) {
				q1.enqueue(random);
				continue;
			}
			for (int i = 0; i < q1.size(); i++) {
				if ((int) q1.peek() == random) {
					flag = false;
					break;
				} else
					q1.enqueue(q1.dequeue());
			}
			if (flag) {
				q1.enqueue(random);
				counter++;
			}
		}
		counter = 1;
		while (counter != 7) {
			flag = true;
			int random = rnd.nextInt(17) + 1;

			if (q2.isEmpty()) {
				q2.enqueue(random);
				continue;
			}
			for (int i = 0; i < q2.size(); i++) {
				if ((int) q2.peek() == random) {
					flag = false;
					break;
				} else
					q2.enqueue(q2.dequeue());
			}
			if (flag) {
				q2.enqueue(random);
				counter++;
			}
		}

		Queue bag1 = new Queue(10000);
		Queue bag2 = new Queue(10000);
		Queue temprandom = new Queue(10000);
		for (int i = 1; i <= 17; i++) {
			bag1.enqueue(i);
		}
		flag=true;
		// GAME

		int q1counter = 0;
		int q2counter = 0;
		int dolar1=0;
		int dolar2=0;
		boolean dolarflag1=true;
		boolean dolarflag2=true;
		while (!q2.isEmpty() || !q1.isEmpty()) {
			int q1size = q1.size();
			int q2size = q2.size();
			int bag1size = bag1.size();
			int bag2size = bag2.size();
			if (flag) {
				System.out.print("\nPlayer 1 : ");
				for (int i = 0; i < q1size; i++) {
					System.out.print(q1.peek() + " ");
					q1.enqueue(q1.dequeue());
				}
				System.out.println(" ");
				System.out.print("Player 2 : ");
				for (int i = 0; i < q2size; i++) {
					System.out.print(q2.peek() + " ");
					q2.enqueue(q2.dequeue());
				}
				System.out.print("                                                      Bag1:       ");
				for (int i = 0; i < bag1size; i++) {
					System.out.print(bag1.peek() + " ");
					bag1.enqueue(bag1.dequeue());
				}
				System.out.print("\n                                                                     Bag2:      ");
				for (int i = 0; i < bag2size; i++) {
					System.out.print(bag2.peek() + " ");
					bag2.enqueue(bag2.dequeue());
				}
				if ((q1counter==4||q2counter==4)&&dolarflag1) {
					
				    if (q1counter==4&&q2counter==4) {
				    	dolar1+=10;
				    	dolar2+=10;
				    	System.out.println("\nPlayer 1 Get 10$");
				    	System.out.println("\nPlayer 2 Get 10$");
				    	dolarflag1=false;
					}
					if (q1counter==4&&dolarflag1) {
						dolar1+=10;
						dolarflag1=false;
						System.out.println("\nPlayer 1 Get 10$");
					}
					else if (q2counter==4&&dolarflag1) {
						dolarflag1=false;
						dolar2+=10;
						System.out.println("\nPlayer 2 Get 10$");
					}
			}
			}

			int y = rnd.nextInt(17) + 1;

			flag = true;
			bag2size = bag2.size();
			for (int i = 0; i < bag2.size(); i++) {
				if (y == (int) bag2.peek()) {
					flag = false;
				} else
					bag2.enqueue(bag2.dequeue());
			}
			if (flag == false) {
				continue;
			} else {
				System.out.println("\nRandomly generated number is : " + y);
				bag1size = bag1.size();
				for (int i = 0; i < bag1size; i++) {
					if ((int) bag1.peek() == y) {
						bag1.dequeue();
					} else
						bag1.enqueue(bag1.dequeue());
				}

				bag2.enqueue(y);

				q1size = q1.size();
				q2size = q2.size();

				for (int i = 0; i < q1size; i++) {// for q1 randomly number
					if ((int) q1.peek() == y) {
						q1.dequeue();
						q1counter++;

					} else
						q1.enqueue(q1.dequeue());
				}
				for (int i = 0; i < q2size; i++) {// for q12randomly number
					if ((int) q2.peek() == y) {
						q2.dequeue();
						q2counter++;

					} else
						q2.enqueue(q2.dequeue());
				}
				
				
				if (q1.size() == 0 || q2.size() == 0) {
					if (q1.size()==0&&q2.size()==0&&dolar1==dolar2) {
						dolar1+=30;
						dolar2+=30;
						System.out.println("\n!!The game is over without any winner \n");
						System.out.println("Player 1 gets : "+dolar1);
						System.out.println("Player 2 gets : "+dolar2);
						break;
					}
					if (q1.size() == 0&&dolar1>dolar2) {
						dolar1+=30;
						
						System.out.println("\n!!Player 1 Won!!");
						System.out.println("Player 1 gets : "+dolar1);
						System.out.println("Player 2 gets : "+dolar2);
						break;
					}
					if (q2.size() == 0&&dolar2>dolar1) {
						dolar2+=30;
						
						System.out.println("\n!!Player 2 Won");
						System.out.println("Player 1 gets : "+dolar1);
						System.out.println("Player 2 gets : "+dolar2);
						break;
					}
					
				}

			}

		}

	}

	}
// YAZDIRMA
/*
 * int q1size=q1.size(); int q2size=q2.size(); for(int i = 0;i<q1size;i++) {
 * System.out.print(q1.dequeue()+ " ");
 * 
 * } System.out.println(" "); for(int i = 0;i<q2size;i++) {
 * System.out.print(q2.dequeue()+" ");
 * 
 * }
 */
