#include <bits/stdc++.h>
using namespace std;

// Function to print the cumulative frequency according to
// the order given
void countFreq(int a[], int n)
{

	// Declaring a map so values get inserted in a sorted
	// manner
	map<int, int> m;

	// Inserting values into the map
	for (int i = 0; i < n; i++) {
		m[a[i]]++;
	}

	// Variable to store the count of previous number
	// cumulative frequency
	int cumul = 0;
	for (auto v : m) {
		cout << v.first << " " << v.second + cumul
			<< endl;
		cumul += v.second;
	}
}

int main()
{
	int arr[] = { 1, 3, 2, 4, 2, 1 };
	int n = sizeof(arr) / sizeof(arr[0]);
	countFreq(arr, n);
	return 0;
}

// This code is contributed by Vinayak Pareek (Kargil)
