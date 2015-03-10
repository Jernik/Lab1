package Maps;
/**
* NPC Data for Reena Bowe at level 2
*/
public class Reena2 extends ConcreteObject.Entity {

	/**
	* The name of the NPC
	*/
	public String name="Reena Bowe";
	/**
	* Constructor, also initializes the dialogue tree.
	*/
	public Reena2() {
		String[] options=null;
		Talking.Talk[] responses=null;
		this.talk=new Talking.Talk("Hello babies!",null,null);
		this.saying=this.talk;
			options=new String[1];
			responses=new Talking.Talk[1];
			options[0]="Um... Hello?";
			responses[0]=new Talking.Talk("Welcome to Sirenia",null,null);
			this.talk.options=options;
			this.talk.responses=responses;
				options=new String[1];
				responses=new Talking.Talk[1];
				options[0]="What is it like here?";
				responses[0]=new Talking.Talk("It's temperate in the summer and temperate in the winter",null,null);
				this.talk.responses[0].options=options;
				this.talk.responses[0].responses=responses;
					options=new String[1];
					responses=new Talking.Talk[1];
					options[0]="Go on...";
					responses[0]=new Talking.Talk("Its square and windy and sparse",null,null);	
					this.talk.responses[0].responses[0].options=options;
					this.talk.responses[0].responses[0].responses=responses;
						options=new String[1];
						responses=new Talking.Talk[1];
						options[0]="Okay";
						responses[0]=new Talking.Talk("At the outside babies you've got about eternity here",null,null);
						this.talk.responses[0].responses[0].responses[0].options=options;
						this.talk.responses[0].responses[0].responses[0].responses=responses;
							options=new String[1];
							responses=new Talking.Talk[1];
							options[0]="Okay";
							responses[0]=new Talking.Talk("There's only one rule that I know of babies",null,null);
							this.talk.responses[0].responses[0].responses[0].responses[0].options=options;
							this.talk.responses[0].responses[0].responses[0].responses[0].responses=responses;
								options=new String[2];
								responses=new Talking.Talk[2];
								options[0]="Okay";
								responses[0]=new Talking.Talk("God damn it, you've got to be colorful",null,null);
								options[1]="What is it?";
								responses[1]=new Talking.Talk("God damn it, you've got to be colorful",null,null);
								this.talk.responses[0].responses[0].responses[0].responses[0].responses[0].options=options;
								this.talk.responses[0].responses[0].responses[0].responses[0].responses[0].responses=responses;
	}
	/**
	* {inheritdoc}
	*/
	public void init() {
		ConcreteObject.Text t=new ConcreteObject.Text();
		t.D=this.D;
		t.Words(this.talk.options[0]);
		t.Displacement(this.xLoc,this.yLoc);
		float angle=(float)(100*Math.random());
		t.Velocity((float)(10*Math.sin(angle)),(float)(10*Math.cos(angle)));
		t.Color(this.red,this.green,this.blue);
		t.talk=this.talk.responses[0];
		t.owner=this;
		this.projectiles.add(t);
	}

}