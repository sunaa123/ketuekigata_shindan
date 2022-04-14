package cc.shinbi.shindan.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shindan {
	private List<Result> results;
	private List<Question> questions;
	
	private Shindan() {
		this.results = new ArrayList<Result>();
		this.questions = new ArrayList<Question>();
	}

	public List<Result> getResults() {
		return results;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public void shuffle() {
		for(Question question : this.questions) {
			question.shuffle();
		}
		Collections.shuffle(this.questions);
	}
	
	private static List<Result> getResultList(){  //結果
		Result[] results = {
				new Result(
					"あなたのほんとうの血液型は",
					"A型です！"
				),
				new Result(
					"あなたのほんとうの血液型は",
					"B型です！"
			    ),
				new Result(
					"あなたのほんとうの血液型は",
					"O型です！"
				),
				new Result(
					"あなたのほんとうの血液型は",
					"AB型です！"
				)
		};
		List<Result> list = Arrays.asList(results);
		return list;
	}
	
	private static List<Question> getQuestionList(){
		List<Question> list = new ArrayList<Question>();
		
		Question question1 = new Question("q1", "あなたに当てはまる性格は？");
		question1. addItem(0, "几帳面");
		question1. addItem(1, "自由奔放");
		question1. addItem(2, "おおらか");
		question1. addItem(3, "あまのじゃく");
		list.add(question1);
		
		Question question2 = new Question("q2", "あなたに当てはまる性格は？");
		question2. addItem(0, "完璧主義");
		question2. addItem(1, "マイペース");
		question2. addItem(2, "現実的");
		question2. addItem(3, "理性で動く合理主義");
		list.add(question2);
		
		Question question3 = new Question("q3", "あなたに当てはまる性格は？");
		question3. addItem(0, "潔癖できれい好き");
		question3. addItem(1, "熱しやすく冷めやすい");
		question3. addItem(2, "細かいことは気にしない");
		question3. addItem(3, "あきっぽい");
		list.add(question3);
		
		Question question4 = new Question("q4", "あなたに当てはまる性格は？");
		question4. addItem(0, "自分より他人を優先");
		question4. addItem(1, "気分屋");
		question4. addItem(2, "頼まれたら断れない");
		question4. addItem(3, "二面性がある");
		list.add(question4);
		
		Question question5 = new Question("q5", "あなたに当てはまる性格は？");
		question5. addItem(0, "社交的で協調性が高い");
		question5. addItem(1, "集団行動より個人行動");
		question5. addItem(2, "八方美人");
		question5. addItem(3, "公平で区別することを嫌う");
		list.add(question5);
		
		return list;
	}
	
	public static Shindan createShindan() {
		Shindan shindan = new Shindan();
		
		List<Result> results = getResultList();
		shindan.getResults().addAll(results);
		
		List<Question> questions = getQuestionList();
		shindan.getQuestions().addAll(questions);
		
		shindan.shuffle();
		
		return shindan;
	}
	
	public Result check(List<Integer> answers) {
		int[] counters = new int[this.results.size()];
		Arrays.fill(counters, 0);
		
		for(Integer index : answers) {
			counters[index]++;
		}
		
		int index = 0;
		int maxCount = 0;
		
		for(int i = 0; i < counters.length; i++) {
			int counter = counters[i];
			if(counter > maxCount) {
				index = i;
				maxCount = counter;
			}
		}
		return this.results.get(index);
	}

}
