
import unittest
from count import count

class TestCount(unittest.TestCase):

    def testValidInput(self):
        self.assertEqual(count(0), 0)
        self.assertEqual(count(1), 1)
        self.assertEqual(count(10), 2)
        self.assertEqual(count(0x7FFFFFFF), 31)
        self.assertEqual(count(0xFFFFFFFF), 32)
        self.assertEqual(count(0x8000000), 1)


if __name__ == '__main__':
    unittest.main()