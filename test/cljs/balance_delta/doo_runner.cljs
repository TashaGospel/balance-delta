(ns balance-delta.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [balance-delta.core-test]))

(doo-tests 'balance-delta.core-test)

