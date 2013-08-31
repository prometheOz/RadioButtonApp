package com.osmansufi.radiobuttonapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayResultsActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		 * Intent firstNameIntent = getIntent(); String first =
		 * firstNameIntent.getStringExtra("first");
		 */

		String first = getIntent().getExtras().getString("first");
		String last = getIntent().getExtras().getString("last");
		double s1 = getIntent().getExtras().getDouble("score1");
		double s2 = getIntent().getExtras().getDouble("score2");
		double s3 = getIntent().getExtras().getDouble("score3");

		int average = (int) Math.round((s1 + s2 + s3) / 3);
		String message = results(average);

		// Layout for the DisplayResultsActivity View
		LinearLayout displayResults = new LinearLayout(this);
		displayResults.setOrientation(1);

		// Child layout of displayResults.
		// Contains "First Name: " text view and user's first name
		LinearLayout nameOne = new LinearLayout(this);
		nameOne.setOrientation(0);
		nameOne.setPadding(10, 10, 10, 5);
		displayResults.addView(nameOne);
		// Text view which simply reads "First Name: "
		TextView fName = new TextView(this);
		fName.setTextSize(20);
		fName.setText("First Name: ");
		nameOne.addView(fName);
		// Text view which displays user's first name
		TextView userFirstName = new TextView(this);
		userFirstName.setTextSize(30);
		userFirstName.setText(first);
		nameOne.addView(userFirstName);

		// Child layout of displayResults.
		// Contains "Last Name: " text view and user's last name
		LinearLayout nameTwo = new LinearLayout(this);
		nameTwo.setOrientation(0);
		nameTwo.setPadding(10, 0, 10, 50);
		displayResults.addView(nameTwo);
		// Text view which simply reads "First Name: "
		TextView lName = new TextView(this);
		lName.setTextSize(20);
		lName.setText("Last Name: ");
		nameTwo.addView(lName);
		// Text view which displays user's first name
		TextView userLastName = new TextView(this);
		userLastName.setTextSize(30);
		userLastName.setText(last);
		nameTwo.addView(userLastName);

		// Text view which simply reads "Assessment: "
		TextView assessmentText = new TextView(this);
		assessmentText.setTextSize(20);
		assessmentText.setText("Assessment: ");
		assessmentText.setPadding(10, 10, 10, 10);
		displayResults.addView(assessmentText);

		// Text view for the actual content of the assessment
		TextView assessment = new TextView(this);
		assessment.setTextSize(30);
		assessment.setText(message);
		assessment.setPadding(10, 0, 10, 10);
		displayResults.addView(assessment);

		// Set the text view as the activity layout
		setContentView(displayResults);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public String results(int t) {
		String results = "";

		if (t == 2)
			results = "Excellent, the pills seem to be working just fine.";
		else if (t == 1)
			results = "Oh. Huh. Interesting. You're just happy. What? Oh, no, there's nothing wrong with that...";
		else if (t == 0)
			results = "Congratulations on being completely dead inside.";
		else if (t == -1)
			results = "Oh, booo hooo, whatta drama queen. Jeez.";
		else if (t == -2)
			results = "ALERT. All of your email and facebook contacts have been alerted regarding your imminent suicide.";

		return results;
	}
}
