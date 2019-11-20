import unittest
from cutrope import dpcut

class TestDpCut(unittest.TestCase):

    def testInvalidInputNull(self):
        with self.assertRaises(ValueError):
            dpcut(-1)

    def testValidInput(self):
        self.assertEqual(dpcut(4), 4)
        self.assertEqual(dpcut(8), 18)
        self.assertEqual(dpcut(9), 27)
        self.assertEqual(dpcut(50), 86093442)


if __name__ == '__main__':
    unittest.main()