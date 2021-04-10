def minWindow(s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        start, minLen = 0, len(s)+1
        left, right = 0, 0
        needs, windows = dict(), dict()
        for c in t:
            if c not in needs.keys():
                needs[c] = 1
            else:
                needs[c] += 1
        match = 0
        while right < len(s):
            c1 = s[right]
            if c1 in needs.keys():
                if c1 in windows.keys():
                    windows[c1] +=1
                else:
                    windows[c1] = 1
                if windows[c1] == needs[c1]:
                    match += 1
            right += 1
            while match == len(needs):
                if right - left < minLen:
                    start = left
                    minLen = right - left
                c2 = s[left]
                if c2 in needs.keys():
                    windows[c2] -= 1
                    if windows[c2] < needs[c2]:
                        match -= 1
                left += 1
        if minLen == len(s)+1:
             return ""
        else:
            return s[start:start+minLen]

if __name__ == "__main__":
    t = minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd")
    print(t)