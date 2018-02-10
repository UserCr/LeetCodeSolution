/**
水题。
**/

void writeCount(char* dest, char* src) {
	char cur_char = src[0];
	int count = 1, write = 0;
	for (int i = 1; src[i] != 0; i++) {
		if (src[i] == cur_char) {
			count++;
		}
		else {
			dest[write++] = count + '0';
			dest[write++] = cur_char;
			count = 1;
			cur_char = src[i];
		}
	}
	dest[write++] = count + '0';
	dest[write++] = cur_char;
}


char* countAndSay(int n) {
	char* result1 = (char*)malloc(10000 * sizeof(char));
	char* result2 = (char*)malloc(10000 * sizeof(char));
	memset(result1, 0, 10000 * sizeof(char));
	memset(result2, 0, 10000 * sizeof(char));

	result1[0] = '1';
	for (int i = 2; i <= n; ++i) {
		if (i % 2 == 0) {
			writeCount(result2, result1);
		}
		else {
			writeCount(result1, result2);
		}
	}
	if (n % 2 == 0) {
		free(result1);
		return result2;
	}
	else {
		free(result2);
		return result1;
	}
}
