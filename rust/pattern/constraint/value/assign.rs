/*
 * Copyright (C) 2022 Vaticle
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

use std::fmt;

use crate::{
    common::{token, validatable::Validatable, Result},
    pattern::{Expression, Reference},
};

#[derive(Debug, Clone, Eq, PartialEq)]
pub struct AssignConstraint {
    pub expression: Expression,
}

impl AssignConstraint {
    pub fn references_recursive(&self) -> Box<dyn Iterator<Item = &Reference> + '_> {
        self.expression.references_recursive()
    }
}

impl Validatable for AssignConstraint {
    fn validate(&self) -> Result<()> {
        Ok(())
    }
}

impl From<Expression> for AssignConstraint {
    fn from(expr: Expression) -> Self {
        Self { expression: expr }
    }
}

impl fmt::Display for AssignConstraint {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{} {}", token::Constraint::Assign, self.expression)
    }
}
