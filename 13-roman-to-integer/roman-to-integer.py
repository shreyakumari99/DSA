class Solution:
    def romanToInt(self, s: str) -> int:
        # 1. Map the Roman numerals to their integer values
        roman_values = {
            'I': 1, 'V': 5, 'X': 10, 'L': 50,
            'C': 100, 'D': 500, 'M': 1000
        }
        
        total = 0
        n = len(s)
        
        # 2. Iterate through the string
        for i in range(n):
            # If current numeral is smaller than the next one, subtract its value
            if i < n - 1 and roman_values[s[i]] < roman_values[s[i+1]]:
                total -= roman_values[s[i]]
            # Otherwise, add its value
            else:
                total += roman_values[s[i]]
                
        return total       