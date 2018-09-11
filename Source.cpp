#include<iostream>
#include<stack>

using namespace std;

void main()
{
	stack <char> number1;
	stack <char> number2;
	stack <int> number3;
	stack <int> number2d;//to store number2 value in because char cannot print out for function .top() //convertion from char to number
	stack <int> number1d;

	//push 12345 for 4 times into number1
	for (int i = 1; i <= 5;i++) {
		number1.push(i);
	}
	for (int i = 1; i <= 5;i++) {
		number1.push(i);
	}
	for (int i = 1; i <= 5;i++) {
		number1.push(i);
	}
	for (int i = 1; i <= 5;i++) {
		number1.push(i);
	}

	//push 11111222223333344444 into number3
	for (int i = 0;i < 5;i++) {
		number2.push(1);
	}
	for (int i = 0;i < 5;i++) {
		number2.push(2);
	}
	for (int i = 0;i < 5;i++) {
		number2.push(3);
	}
	for (int i = 0;i < 5;i++) {
		number2.push(4);
	}

	//store number1 & number2 into int type stack for output
	//add the num of number1 and number1 accordingly
	//store the product of addition inside number3
	while (number1.empty() != true) {
		int pop_v;
		int sum;
		number1d.push(number1.top());
		number2d.push(number2.top());
		sum = number1.top() + number2.top();
		number1.pop();
		number2.pop();
		number3.push(sum);
	}

	//display number in number1
	while (number1d.empty() != true) {
		cout << number1d.top();
		number1d.pop();
	}

	cout << " +  ";

	//display number in number2
	while (number2d.empty() != true) {
		cout << number2d.top() ;
		number2d.pop();
	}

	cout << " = ";

	//display number3
	while (number3.empty() != true) {
		cout << number3.top();
		number3.pop();
	}

	cout << endl;
}